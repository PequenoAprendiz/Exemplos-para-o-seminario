
public class ValidaCpfModificado{
    
   String cpf = "114.985.886-97";
    char[] digitosCpfSemMask = new char[11];                           // cria um segundo array do  tipo char para poder realizar os cÃ¡lcos em os sinais de '.' e de '-'
    char[] digitosCpf = cpf.toCharArray();
    int somatorio = 0;
    int restoDivisao;
    int peso = 10;

    public static void main(String args[]) {
        
        ValidaCpfModificado validaCpfModificado = new ValidaCpfModificado();
        validaCpfModificado.manipulaArrays();
    }

     public void manipulaArrays() {
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
        this.ResultadoValidacao();
    }

    public void ResultadoValidacao() {
       System.out.print( this.comparacaoDeDigitosCalculados());
    }

    public String comparacaoDeDigitosCalculados() {
        if (Integer.parseInt("" + digitosCpfSemMask[9]) == calculaPrimeiroDigitoVerificador()
                && Integer.parseInt("" + digitosCpfSemMask[10]) == calculaSegundoDigitoVerificador()) {
            return ("Cpf Válido");
        } else {
            return ("Cpf Inválido");
        }
    }

    public int calculaPrimeiroDigitoVerificador() {
        /////varaiveis auxiliares                
        int digitoVerificador1;
        peso = 10;
        //definindo o primeiro dÃ­gito verificador do cpf                
        for (int x = 0; x <= 8; x++) {
            somatorio += (Integer.parseInt("" + digitosCpfSemMask[x]) * peso);  // conversÃ£o de char para int toda vez que houver uma iterÃ§Ã£o, e calculanado o somatÃ³rio.
            peso = peso - 1;                                                    // decremento de 'peso' para poder realizar o cÃ¡lculo do somatÃ³rio de acordo com a regra 
        }
        restoDivisao = somatorio % 11;                                          // calculando resto da divisÃ£o

        if (restoDivisao < 2) {                                                 // se o resto da divisÃ£o for 10 ou 11 define 0 para o 1ÂºDV
            return digitoVerificador1 = 0;
        } else {
            return digitoVerificador1 = 11 - restoDivisao;                             // senÃ£o define o resto da divisÃ£o calculado anteriormente para o 1ÂºDV
        }
    }

    public int calculaSegundoDigitoVerificador() {
        peso = 11;                                                              // 'peso' passa a valer 11 para poder atender a regra, que diz para  o 2ÂºDV deve entrar no somatÃ³rio o 1ÂºDV encontrado anteriormente
        somatorio = 0;
        restoDivisao = 0;
        int digitoVerificador2;
        for (int x = 0; x <= 9; x++) {
            somatorio += (Integer.parseInt("" + digitosCpfSemMask[x]) * peso);
            peso = peso - 1;
        }
        restoDivisao = somatorio % 11;

        if (restoDivisao < 2) {
            return digitoVerificador2 = 0;
        } else {
            return digitoVerificador2 = 11 - restoDivisao;
        }
    }
}
