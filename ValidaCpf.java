package br.edu.ifnmg.wellington.systemavalidacpf;

public class ValidaCpf {

    public void validar(String cpf) {
        

        if (cpf.equals("000.000.000-00") || cpf.equals("111.111.111-11")
                || cpf.equals("222.222.222-22") || cpf.equals("333.333.333-33")
                || cpf.equals("444.444.444-44") || cpf.equals("555.555.555-55")
                || cpf.equals("666.666.666-66") || cpf.equals("777.777.777-77")
                || cpf.equals("888.888.888-88") || cpf.equals("999.999.999-99")
                || cpf.length() != 14) {
            System.out.println("Cpf invalido");
            throw new cpfInformadoIncorretoException(cpf);
        } else {

                      
            char[] digitosCpfSemMask = new char[11];                           // cria um segundo array do  tipo char para poder realizar os cálcos em os sinais de '.' e de '-'
            char[] digitosCpf = cpf.toCharArray();                             // converte cpf String e cria um array de chars com base na cpf String  

            if (digitosCpf[3] == '.' && digitosCpf[7] == '.' && digitosCpf[11] == '-') {        // última verificação pra ter certeza que o valor inserido tem a mácara de um CPF

                // passando valores de digitosCpf que tem a máscara de CPF para o segundo array que não terá essa máscara, facilitando o calculo dos DV 
                digitosCpfSemMask[0] = digitosCpf[0];
                digitosCpfSemMask[1] = digitosCpf[1];
                digitosCpfSemMask[2] = digitosCpf[2];
                digitosCpfSemMask[3] = digitosCpf[4];
                digitosCpfSemMask[4] = digitosCpf[5];
                digitosCpfSemMask[5] = digitosCpf[6];
                digitosCpfSemMask[6] = digitosCpf[8];
                digitosCpfSemMask[7] = digitosCpf[9];
                digitosCpfSemMask[8] = digitosCpf[10];
                digitosCpfSemMask[9] = digitosCpf[12];
                digitosCpfSemMask[10] = digitosCpf[13];

                /////varaiveis auxiliares
                int somatorio = 0;
                int digitoVerificador1;
                int digitoVerificador2;
                int restoDivisao;
                int peso = 10;

                //definindo o primeiro dígito verificador do cpf                
                for (int x = 0; x <= 8; x++) {
                    somatorio += (Integer.parseInt("" + digitosCpfSemMask[x]) * peso);  // conversão de char para int toda vez que houver uma iterção, e calculanado o somatório.
                    peso = peso - 1;                                                    // decremento de 'peso' para poder realizar o cálculo do somatório de acordo com a regra 
                }
                restoDivisao = somatorio % 11;                                          // calculando resto da divisão
                if (restoDivisao < 2) {                                                 // se o resto da divisão for 10 ou 11 define 0 para o 1ºDV
                    digitoVerificador1 = 0;
                } else {
                    digitoVerificador1 = 11 - restoDivisao;                             // senão define o resto da divisão calculado anteriormente para o 1ºDV
                }

                //definindo o segundo digito verificador do cpf
                peso = 11;                                                              // 'peso' passa a valer 11 para poder atender a regra, que diz para  o 2ºDV deve entrar no somatório o 1ºDV encontrado anteriormente
                somatorio = 0;
                restoDivisao = 0;
                for (int x = 0; x <= 9; x++) {
                    somatorio += (Integer.parseInt("" + digitosCpfSemMask[x]) * peso);
                    peso = peso - 1;
                }
                restoDivisao = somatorio % 11;
                if (restoDivisao < 2) {
                    digitoVerificador2 = 0;
                } else {
                    digitoVerificador2 = 11 - restoDivisao;
                }

                // exibindo resultados da verificação
                if (Integer.parseInt("" + digitosCpfSemMask[9]) == digitoVerificador1
                        && Integer.parseInt("" + digitosCpfSemMask[10]) == digitoVerificador2) {
                    System.out.println("Cpf Válido");
                    for (int x = 0; x <= 13; x++) {
                        System.out.print(digitosCpf[x]);
                    }
                } else {
                    System.out.println("Cpf Inválido");
                    for (int x = 0; x <= 13; x++) {
                        System.out.print(digitosCpf[x]);
                    }
                }
            } else {
                System.out.println("Cpf invalido");
                throw new cpfInformadoIncorretoException(cpf);
            }
        }
    }
}

//tentando atribuir os valore do array digitosCpf para o outro digitosCpfSemMask, sem os '.' e o '-'
//               for (int x = 0; x <= 10; x++) { 
//                    if (digitosCpf[x] != '.' || digitosCpf[x] != '-') {
//                        digitosCpfSemMask[x] = digitosCpf[x]; 
//                    }
//                }
////animação de loading
//            System.out.print("Carregando: ");
//            for (int cont = 0; cont <= 5; cont++) {
//                char c = '#';
//                System.out.print("\t" + c);
//
//                //animação de carregamento
//                try {
//                    Thread.sleep(400); // 2 segundos = 2000 milissegundos // 0,4 segundos nesse caso 
//                } catch (InterruptedException ex) {
//                    Thread.currentThread().interrupt();
//                }
//            }
