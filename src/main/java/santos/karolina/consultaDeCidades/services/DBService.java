package santos.karolina.consultaDeCidades.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santos.karolina.consultaDeCidades.entities.Cidade;
import santos.karolina.consultaDeCidades.entities.Estado;
import santos.karolina.consultaDeCidades.entities.Pais;
import santos.karolina.consultaDeCidades.repositories.CidadeRepository;
import santos.karolina.consultaDeCidades.repositories.EstadoRepository;
import santos.karolina.consultaDeCidades.repositories.PaisRepository;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    private String urlBancoDeDados = "https://github.com/chinnonsantos/sql-paises-estados-cidades/blob/master/PostgreSQL/estado.sql";

    public  void criarBanco(){
        Pais pais1 = new Pais(null, "Brazil", "Brasil", "BR", 1058);
        Pais pais2 = new Pais(null, "Afghanistan", "Afeganistão", "AF", 132);
        Pais pais3 = new Pais(null, "American Samoa", "Samoa Americana", "AS", 6912);
        Pais pais4 = new Pais(null, "Albania", "Albânia, Republica da", "AL", 175);
        Pais pais5 = new Pais(null, "Algeria", "Argélia", "DZ", 590);
        Pais pais6 = new Pais(null, "Andorra", "Andorra", "AD", 370);
        Pais pais7 = new Pais(null, "Angola", "Angola", "AO", 400);
        Pais pais8 = new Pais(null, "Anguilla", "Anguilla", "AI", 418);
        Pais pais9 = new Pais(null, "Antarctica", "Antártida", "AQ", 3596);
        Pais pais10 = new Pais(null,  "Antigua and Barbuda", "Antigua e Barbuda", "AG", 434);

        Pais pais11 = new Pais(null, "Argentina", "Argentina", "AR", 639);
        Pais pais12 = new Pais(null, "Armenia", "Armênia, Republica da", "AM", 647);
        Pais pais13 = new Pais(null, "Aruba", "Aruba", "AW", 655);
        Pais pais14 = new Pais(null, "Australia", "Austrália", "AU", 698);
        Pais pais15 = new Pais(null, "Bahamas", "Bahamas, Ilhas", "BS", 779);
        Pais pais16 = new Pais(null, "Austria", "Áustria", "AT", 728);
        Pais pais17 = new Pais(null, "Azerbaijan", "Azerbaijão, Republica do", "AZ", 736);
        Pais pais18 = new Pais(null, "Bahrain", "Bahrein, Ilhas", "BH", 809);
        Pais pais19 = new Pais(null, "Bangladesh", "Bangladesh", "BD", 817);
        Pais pais20 = new Pais(null, "Barbados", "Barbados", "BB", 833);

        Pais pais21 = new Pais(null, "Belarus", "Belarus, Republica da", "BY", 850);
        Pais pais22 = new Pais(null, "Belgium", "Bélgica", "BE", 876);
        Pais pais23 = new Pais(null, "Belize", "Belize", "BZ", 884);
        Pais pais24 = new Pais(null, "Benin", "Benin", "BJ", 2291);
        Pais pais25 = new Pais(null, "Bermuda", "Bermudas", "BM", 906);
        Pais pais26 = new Pais(null, "Bosnia and Herzegowina", "Bósnia-herzegovina (Republica da)", "BA", 981);
        Pais pais27 = new Pais(null, "Bhutan", "Butão", "BT", 1198);
        Pais pais28 = new Pais(null, "Bolivia","Bolívia", "BO", 973);
        Pais pais29 = new Pais(null, "Botswana", "Botsuana", "BW", 1015);
        Pais pais30 = new Pais(null, "Bouvet Island", "Bouvet, Ilha", "BV", 1023);

        Pais pais31 = new Pais(null, "British Indian Ocean Territory", "Território Britânico do Oceano Indico", "IO", 7820);
        Pais pais32 = new Pais(null, "Brunei Darussalam", "Brunei", "BN", 1082);
        Pais pais33 = new Pais(null, "Bulgaria", "Bulgária, Republica da", "BG", 1112);
        Pais pais34 = new Pais(null, "Burkina Faso", "Burkina Faso", "BF", 310);
        Pais pais35 = new Pais(null, "Burundi", "Burundi", "BI", 1155);
        Pais pais36 = new Pais(null, "Cambodia", "Camboja", "KH", 1414);
        Pais pais37 = new Pais(null, "Cameroon", "Camarões", "CM", 1457);
        Pais pais38 = new Pais(null, "Canada", "Canada", "CA", 1490);
        Pais pais39 = new Pais(null, "Cape Verde", "Cabo Verde, Republica de", "CV", 1279);
        Pais pais40 = new Pais(null, "Cayman Islands", "Cayman, Ilhas", "KY", 1376);


        paisRepository.saveAll(Arrays.asList(pais1, pais2,pais3,pais4,
                pais5,pais6,pais7,pais8,pais9,pais10,pais11,pais12,pais13,pais14,
                pais15,pais16,pais17,pais18,pais19,pais20));
        paisRepository.saveAll(Arrays.asList(pais21,pais22,pais23,pais24,pais25,pais26,pais27,pais28,pais29,pais30));
        paisRepository.saveAll(Arrays.asList(pais31,pais32,pais33,pais34,pais35,pais36,pais37,pais38,pais39,pais40));

        //estados do brasil
        Estado estado1 = new Estado(null, "Acre", "AC", 12, pais1);
        Estado estado2 = new Estado(null, "Alagoas", "AL", 27, pais1);
        Estado estado3 = new Estado(null, "Amazonas", "AM", 13, pais1);
        Estado estado4 = new Estado(null, "Amapá", "AP", 16, pais1);
        Estado estado5 = new Estado(null, "Bahia", "BA", 29, pais1);
        Estado estado6 = new Estado(null, "Ceará", "CE", 23, pais1);
        Estado estado7 = new Estado(null, "Distrito Federal", "DF", 53, pais1);
        Estado estado8 = new Estado(null, "Espírito Santo", "ES", 32, pais1);
        Estado estado9 = new Estado(null, "Goiás", "GO", 52, pais1);
        Estado estado10 = new Estado(null, "Maranhão", "MA", 21, pais1);

        Estado estado11 = new Estado(null, "Minas Gerais", "MG", 31, pais1);
        Estado estado12 = new Estado(null, "Mato Grosso do Sul", "MS", 50, pais1);
        Estado estado13 = new Estado(null, "Mato Grosso", "MT", 51, pais1);
        Estado estado14 = new Estado(null, "Pará", "PA", 15, pais1);
        Estado estado15 = new Estado(null, "Paraíba", "PB", 25, pais1);
        Estado estado16 = new Estado(null, "Pernambuco", "PE", 26, pais1);
        Estado estado17 = new Estado(null, "Piauí", "PI", 22, pais1);
        Estado estado18 = new Estado(null, "Paraná", "PR", 41, pais1);
        Estado estado19 = new Estado(null, "Rio de Janeiro", "RJ", 33, pais1);
        Estado estado20 = new Estado(null, "Rio Grande do Norte", "RN", 24, pais1);

        Estado estado21 = new Estado(null, "Rondônia", "RO", 11, pais1);
        Estado estado22 = new Estado(null, "Roraima", "RR", 14, pais1);
        Estado estado23 = new Estado(null, "Rio Grande do Sul", "RS", 43, pais1);
        Estado estado24 = new Estado(null, "Santa Catarina", "SC", 42, pais1);
        Estado estado25 = new Estado(null, "Sergipe", "SE", 28, pais1);
        Estado estado26 = new Estado(null, "São Paulo", "SP", 35, pais1);
        Estado estado27 = new Estado(null, "Tocantins", "TO", 17, pais1);

        estadoRepository.saveAll(Arrays.asList(estado1,estado2,estado3,estado4,
                estado4,estado5,estado6,estado7,estado8,estado9,estado10,estado11,estado12,
                estado13,estado14,estado15,estado16,estado17,estado18,estado19,estado19,estado20,
                estado21,estado22,estado23,estado24,estado25,estado26,estado27));

        pais11.getEstados().addAll(Arrays.asList(estado1,estado2,estado3,estado4,
                estado4,estado5,estado6,estado7,estado8,estado9,estado10,estado11,estado12,
                estado13,estado14,estado15,estado16,estado17,estado18,estado19,estado19,estado20,
                estado21,estado22,estado23,estado24,estado25,estado26,estado27));


        //cidades do maranhao
        Cidade cidade1 = new Cidade(null, "SÃO JOSE DE RIBAMAR", 2111201, estado10);
        Cidade cidade2 = new Cidade(null, "SÃO LUÍS", 2111300	, estado10);
        Cidade cidade3 = new Cidade(null, "IMPERATRIZ", 2105302, estado10);
        Cidade cidade4 = new Cidade(null, "TIMON", 2112209	, estado10);
        Cidade cidade5 = new Cidade(null, "CAXIAS", 2103000	, estado10);
        Cidade cidade6 = new Cidade(null, "CODÓ", 2103307	, estado10);
        Cidade cidade7 = new Cidade(null, "PAÇO DO LUMIAR", 2107506, estado10);
        Cidade cidade8 = new Cidade(null, "BACABAL", 2101202, estado10);
        Cidade cidade9 = new Cidade(null, "AÇAILÂNDIA", 2100055, estado10);
        Cidade cidade10 = new Cidade(null, "BALSAS", 2101400, estado10);
        cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4,cidade5,cidade6,cidade7,cidade8,cidade9,cidade10));

        estado10.getCidades().addAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4,cidade5,cidade6,cidade7,cidade8,cidade9,cidade10));
    }
}
