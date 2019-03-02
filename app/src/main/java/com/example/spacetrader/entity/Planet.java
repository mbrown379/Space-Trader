package com.example.spacetrader.entity;

import java.io.Serializable;

public class Planet implements Serializable {

    private String name;
    private TechLevel techLevel;
    private ResourceType resourceType;
    private Government government;
    private Market market;

    /**
     * Planet constructor
     * Will create a random techLevel, resourceType, and Government
     */
    public Planet() {
        this.name = generateRandomName();
        this.techLevel = TechLevel.values()[(int) (Math.random() * TechLevel.values().length)];
        this.resourceType = ResourceType.values()[(int) (Math.random() * ResourceType.values().length)];
        this.government = Government.values()[(int) (Math.random() * Government.values().length)];
        this.market = new Market(name, techLevel, resourceType);
    }

    /**
     * Generates a random name or random string of numbers and letters.
     * @return
     */
    private String generateRandomName() {
        int randomInt = (int)(Math.random() * planetNames.length);
        String randomName = planetNames[randomInt];
        planetNames[randomInt] = ""
                + (char)(97 + (int)(Math.random() * 26)) + (int)(Math.random() * 100);
        return randomName;
    }

    private static String planetNames[] =
            {"Acotera", "Ademia", "Ahines", "Aliatis", "Alvuter", "Anides", "Astrurn", "Atis",
            "Atune", "Babbara", "Bacrars", "Baethea", "Balnitania", "Bendulea", "Benrarth",
            "Berocury", "Bezahiri", "Bianus", "Bithaovis", "Bitholea", "Bivichi", "Bochone",
            "Bodinus", "Bodriayama", "Boilea", "Bolluruta", "Braoter", "Brizothea", "Brubonia",
            "Buatania", "Cabiyama", "Cadus", "Calmeron", "Calviea", "Cathater", "Cavenia",
            "Ceatera", "Cebberus", "Cemanope", "Ceoter", "Cestrumia", "Chadetera", "Chalrerth",
            "Chastryria", "Chatov", "Chaverth", "Cheter", "Cheutis", "Cheuyama", "Chinkalara",
            "Chinkinov", "Chithea", "Chitrao", "Chixehiri", "Chobrubos", "Cholmaewei", "Cholopra",
            "Chonypso", "Cibreunides", "Cinus", "Cinzillon", "Ciothea", "Coihiri", "Colalara",
            "Couhiri", "Credurilia", "Crixotis", "Croestea", "Cryria", "Culea", "Culreogantu",
            "Cuziyama", "Dahaturn", "Dapelea", "Delrurn", "Dillialea", "Dinvihines", "Dipheron",
            "Dobenerth", "Dothathea", "Drabanus", "Dresetania", "Drezewei", "Dritutania",
            "Driveter", "Dromeruta", "Drosotov", "Dubone", "Dugniri", "Duhulea", "Dukihiri",
            "Eathea", "Echonoe", "Emilia", "Ennoria", "Gabremia", "Gaoliv", "Garanus", "Gibbarth",
            "Gicrazuno", "Gicrilara", "Giethea", "Giutis", "Gnabuhines", "Gnabuthea", "Gnodonus",
            "Gnounus", "Gnoxinov", "Gnudetune", "Godayama", "Gognoter", "Golraitania", "Gomorix",
            "Goturn", "Gougawa", "Gracheyama", "Grechanus", "Groacarro", "Groluter", "Grudeliv",
            "Guistea", "Gukotov", "Hadunia", "Heatis", "Hendieliv", "Hogantu", "Hulia", "Ianov",
            "Ibbippe", "Iboutera", "Ichinda", "Idrarth", "Iniaphus", "Inreiter", "Inzion", "Ioyama",
            "Isara", "Isore", "Istrora", "Itholla", "Ithurn", "Iuvis", "Kacrevis", "Kanov",
            "Kastea", "Katurn", "Kawei", "Keccagua", "Kenrarvis", "Keunus", "Keutera", "Kithurn",
            "Koistea", "Kolorilia", "Kuetis", "Lestrion", "Levurus", "Lezacarro", "Libegawa",
            "Lienides", "Llerenides", "Llexatune", "Llilastea", "Lloyetis", "Longarvis",
            "Mabbilles", "Macadus", "Maphore", "Maubos", "Menzabos", "Metruinov", "Meyama",
            "Miditov", "Moputov", "Moter", "Motronoe", "Muruta", "Muturn", "Nagaphus", "Natrilia",
            "Nedurn", "Nelia", "Neluiturn", "Neperuta", "Nibbagua", "Nisunia", "Nohines",
            "Noicarro", "Nolara", "Nolneshan", "Nothaewei", "Notov", "Nubbiruta", "Nucruthea",
            "Nundizuno", "Nunrehines", "Nunus", "Oaturn", "Obuinerth", "Oclite", "Ohines",
            "Ollezuno", "Ololla", "Onerth", "Onrore", "Onveotis", "Onzuegawa", "Ostea", "Oturn",
            "Oyama", "Palmuhines", "Palvilia", "Pecceshan", "Pethuter", "Phedania", "Phieclite",
            "Phion", "Pomia", "Ponosie", "Pubrars", "Pungaria", "Punus", "Putrapus", "Raclite",
            "Raumia", "Rephorix", "Ribosie", "Rillion", "Rolnaeria", "Ronzeshan", "Rubruna",
            "Rulazuno", "Ruter", "Saaclite", "Saephus", "Sagantu", "Senziea", "Siinus", "Sinzeshan",
            "Siphiarus", "Siyama", "Soahines", "Soregantu", "Straxaliv", "Strerovis", "Struxeclite",
            "Suenope", "Suipra", "Sulneoria", "Tacuenus", "Taenope", "Tengade", "Tenkichi",
            "Tennelea", "Tenrillon", "Thaiter", "Thamutov", "Thanzoria", "Thapatov", "Thetonia",
            "Thillewei", "Tholion", "Thosarth", "Thuastea", "Thuccitov", "Thudore", "Thunia",
            "Thuphyria", "Thuziurilia", "Tidraitune", "Tinkietania", "Togratis", "Tonides",
            "Tostradus", "Toter", "Trazeter", "Trenuwei", "Trileruta", "Tripaphus", "Trobilia",
            "Trovatov", "Trucunus", "Truvinus", "Tuilia", "Tuliv", "Uahiri", "Uestea", "Ugnore",
            "Uibos", "Ulnorth", "Ulveuter", "Unkiri", "Uphara", "Usourilia", "Uturn", "Vaenerth",
            "Vatov", "Vayutis", "Vecetis", "Veocury", "Vephiuwei", "Vihines", "Vimov", "Visunov",
            "Viuliv", "Volvichi", "Vubbaoyama", "Vubiea", "Vucriri", "Vunion", "Vuthoamia",
            "Xatania", "Xebahiri", "Xenzaitov", "Xiaphus", "Xithomia", "Xochayama", "Xodeon",
            "Xograo", "Xoitune", "Xoliugawa", "Xophestea", "Xutov", "Yagnomia", "Yameron",
            "Yecciea", "Yeccov", "Yenvion", "Yonzienus", "Yuenerth", "Zanonus", "Zegnuruta",
            "Zevulia", "Zienope", "Zilater", "Zippe", "Zithea", "Zithenus", "Zitune", "Zucury"};

    @Override
    public String toString() {
        return "Planet: " + name + ", TechLeveL: " + techLevel.toString() + ", ResourceType: "
                + resourceType.toString() + ", Government: " + government.toString();
    }

}