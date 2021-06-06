package com.example.batikkita.utils

import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.IslandEntity

object DummyObject {

    fun generateBatik(): List<BatikEntity> {

        val batik = ArrayList<BatikEntity>()

        batik.add(
            BatikEntity(
                id = 1,
                name = "Batik Betawi",
                image = "https://th.bing.com/th/id/OIP.tHieZBhdakzYtx8PFIuf4AAAAA?w=201&h=141&c=7&o=5&pid=1.7",
                province = "DKI Jakarta",
                origin = "Jakarta",
                island = "Jawa",
                theme = "human, geometric, monument",
                color = "red, black, orange",
                complexity = "medium",
                pattern = "Batik Betawi motif is heavily influenced by a slew of patterns that is originated from the northern part of the Java island, that is mostly revolving around coastal themes. Batik Betawi motif is influenced by Chinese culture and Arabic calligraphy.\n" +
                        "\n" +
                        "Commonly found Batik Betawi motif is a depiction of ondel-ondel, the National Monument/Monas, triangles, cokek dance, tumpal, macungan and pucuk rebung.",
                desc = "Batik Betawi is a traditional batik pattern that is originated in Jakarta. Batik Betawi started to be produced in the 19th century. The word Betawi refers to an ethnic group indigenous to the region Jakarta."
            )
        )

        batik.add(
            BatikEntity(
                id = 2,
                name = "Batik Cendrawasih",
                image = "https://th.bing.com/th/id/OIP.RDJVl1HPex2N5L5BkSUHtwAAAA?w=185&h=186&c=7&o=5&pid=1.7",
                origin = "Papua",
                province = "Papua, Papua Barat",
                island = "Papua",
                theme = "fauna",
                color = "dark blue, brown, yellow",
                complexity = "high",
                pattern = "Batik Cendrawasih main motif of the cendrawasih bird. The cendrawasih is Papua’s endemic species with beautiful feathers and tails. Cendrawasih Bird motif tells a message of the human-nature relationship. This motif is often combined with traditional Papuanese patterns and local flora.",
                desc = "Batik Cendrawasih is a traditional Papua’s batik that is developed at around 1985. Batik Cendrawasih motif is a mixture of Papuanese and Pekalongan culture. Pekalongan is a Javanese ethnicity as a batik producer combined with Papuan ethnicity which is rich in decoration which is developed as a batik motif. The mixture of these cultures makes this batik also known as Port Numbay batik. Batik Cendrawasih has its uniqueness from the aspect of the motif because it was developed from the rich culture and uniqueness of the exotic nature of Papua."
            )
        )

        batik.add(
            BatikEntity(
                id = 3,
                name = "Batik Ceplok",
                image = "https://th.bing.com/th/id/OIP.nJDccL6Ie2tilSELNzUBWQAAAA?w=115&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                province = "Jawa Tengah",
                theme = "geometric",
                color = "brown",
                complexity = "medium",
                island = "Jawa",
                pattern = "Batik Ceplok or Ceplokan is a batik with geometrical patterns such as squares, ovals, or stars that are constructed in a circular formation to form a flower. This motif is inspired by kawung fruit or palm Fruit that’s split in quarters.",
                desc = "Batik Ceplok was formerly made as clothing for the residents of the Kotagede palace or the Mataram kingdom at that time. The motifs are adopted from the influence of Hindu and Buddhist cultures."
            )
        )

        batik.add(
            BatikEntity(
                id = 4,
                name = "Batik Lasem",
                image = "https://th.bing.com/th/id/OIP.EioGZ1j5nehrrt66gbAcAAHaFj?w=213&h=180&c=7&o=5&pid=1.7",
                origin = "Lasem",
                province = "Jawa Tengah",
                theme = "flora, fuana",
                color = "orange, red",
                complexity = "high",
                island = "Jawa",
                pattern = "Generally, this batik has two main motifs, one is the depiction of faunas with a blend of mythological Chinese animals such as hong bird, dragon, wild chicken, etc, etc. And the other one, the Javanese influenced with a motif of sekar jagad, kencoro kendiri, kricak, grinsing, and others.",
                desc = "Batik Lasem is also known as ‘batik tiga negeri’ meaning three-country batik because traditionally Batik Lasem is gone through a three-step coloring process in three different places. Red in Lasem, blue in Pekalongan, and brown in Surakarta. \n" +
                        "\n" +
                        "Batik Lasem is a blend of Chinese and Javanese culture. Batik Lasem has an extensive history correlated to Admiral Cheng Ho. Lasem is the place where Admiral Cheng Ho first landed in Central Java with its Chinese followers.\n" +
                        "\n" +
                        "In Babad Lasem (the Tales of Lasem) written by Raden Panji Kamzah in 1858, it is told that Bi Nang Un, the crewmate of the ship Dhang Puhawang Tzeng Ho from China with his wife Na Li Ni decided to live in Bonang, Central Java. It is believed that Na Li Ni is the first person to make Batik Lasem with hong bird motif, seruni, liong, currency, and banji with a distinctively Chinese red coloring."
            )
        )

        batik.add(
            BatikEntity(
                id = 5,
                name = "Batik Megamendung",
                image = "https://th.bing.com/th/id/OIP.rCcIsuRjhanzIjw9lg3uoQHaHa?w=198&h=198&c=7&o=5&pid=1.7",
                origin = "Cirebon",
                province = "Jawa Barat",
                theme = "cloud",
                color = "blue, red",
                complexity = "low",
                island = "Jawa",
                pattern = "This batik has a uniquely distinct pattern that is not found in other areas of Indonesia. Megamendung is a depiction of clouds before the rain, symbolizing the rain giver which brings fertility and life to earth.\n" +
                        "\n" +
                        "The color blue is used to depict the vastness and friendliness of the sky. Blue and red are also used to depict the psychology of the coastal people that is accepting and open. \n" +
                        "\n" +
                        "With time batik megamendung pattern is evolved with the demand of the market. Motifs such as floras, faunas, and others are introduced along with alternative colors such as yellow, green, brown, etc.",
                desc = "Batik Megamendung is an iconic batik from Cirebon. “Mega” means cloud and “mendung’ means cloudy. Batik Megamendung is known internationally and is used as the cover of a book called Batik Design by Pepin van Roojen. \n" +
                        "\n" +
                        "Cirebon is once a bustling international port that is used as a stop for international traders. Numerous historical text and literature point to the emergence of the pattern from the arrival of the Chinese traders in the Cirebon region. With the Chinese came Taoism; in Taoism, the clouds are a depiction of the “upper world” that is transcendental in nature. This concept also seeps into Sufism that is used to depict free nature."
            )
        )

        batik.add(
            BatikEntity(
                id = 6,
                name = "Batik Parang",
                image = "https://th.bing.com/th/id/OIP._kf_2DziiUGc-r5J2o39fgHaD4?w=339&h=181&c=7&o=5&pid=1.7",
                origin = "Sukoharjo",
                province = "Jawa Tengah",
                theme = "geometric",
                color = "brown, white",
                complexity = "low",
                island = "Jawa",
                pattern = "The motif is usually a series of “S” shapes that is interconnected together diagonally which makes a downward slope. These shapes are inspired by the waves of the sea that depict continuity, and an attitude of never giving up; a never-ending spirit.",
                desc = "Batik Parang is one of the oldest motifs of batik in Indonesia. There’s a little bit of a dispute over the name, some say that “parang” is derived from the word “pereng” meaning “slope” others say that “parang” came from the word “perang” meaning war, a war over self-control over everyday temptations. It is told that only kings can use Batik Parang as a symbolism of devotion toward family, nation, and religion."
            )
        )

        batik.add(
            BatikEntity(
                id = 7,
                name = "Batik Sekar",
                image = "https://th.bing.com/th/id/OIP._jdwFac0FHn7EUxlC3YpnwHaD4?w=310&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                province = "Jawa Tengah",
                island = "Jawa",
                theme = "flora, geometric",
                color = "brown",
                complexity = "high",
                pattern = "Batik Sekar’s pattern is complex and intricate. Using floral and geometric patterns and is constructed in such a way that the pattern feels loose and relaxed. The batik is peppered with small little dots that are spread on the cloth.",
                desc = "Batik Sekar or also known as Batik Sekar Jagad is a batik that came from Yogyakarta in the 18th century. Batik Sekar is a depiction of the world map in a piece of cloth.\n" +
                        "\n" +
                        "The word “sekar jagad” came from the word “kar” and “jagad” from Javanese. “Kar” meaning map and “jagad” meaning world. Based on this translation, sekar jagad depicts the diversity of the world."
            )
        )

        batik.add(
            BatikEntity(
                id = 8,
                name = "Batik Sidoluhur",
                image = "https://th.bing.com/th/id/OIP.qGMHD6toLUR8tnrG_v8quQHaEN?w=259&h=183&c=7&o=5&pid=1.7",
                origin = "Surakarta",
                theme = "fauna, flora",
                province = "Jawa Tengah",
                color = "brown",
                complexity = "high",
                island = "Jawa",
                pattern = "Batik Sidoluhur pattern consists of diamonds that are arranged in a diagonal grid-like pattern with gaps between the diamond. In the middle of the diamond, there are detailing that often consists of two separate motifs, often fauna that is encased by flora motif.",
                desc = "The word \"sida\" in Javanese itself means so/become, and the word “luhur” means noble. As the name implies, this motif means the hope to become a role model for the community (nobility). Batik motifs starting with “sida” (pronounced sido) are a class of common batik motif that is very popular amongst batik craftsmen.\n" +
                        "\n" +
                        "Batik Sidoluhur is a traditional batik that exist before the Mataram Sultanate. Batik sidoluhur is made by Ki Ageng Henis, the grandfather of Panembahan Senopati the founder of the Mataram Sultanate. Ki Ageng Henis is believed to be someone who has magical powers. It is believed that the motive behind the creation of the batik is for his descendants to come."
            )
        )

        batik.add(
            BatikEntity(
                id = 9,
                name = "Batik Sidomukti",
                image = "https://th.bing.com/th/id/OIP.xS3cJXJ-lmMhxBG8vUiavQHaHa?w=166&h=180&c=7&o=5&pid=1.7",
                origin = "Surakarta",
                province = "Jawa Tengah",
                theme = "fauna, flora",
                color = "brown",
                complexity = "high",
                island = "Jawa",
                pattern = "Batik Sidoluhur pattern consists of diamonds that are arranged in a diagonal grid-like pattern with gaps between the diamond. In the middle of the diamond, there are detailing that often consists of two separate motifs, often fauna that is encased by flora motif.",
                desc = "The word \"sida\" in Javanese itself means so/become, and the word “luhur” means noble. As the name implies, this motif means the hope to become a role model for the community (nobility). Batik motifs starting with “sida” (pronounced sido) are a class of common batik motif that is very popular amongst batik craftsmen.\n" +
                        "\n" +
                        "Sidomukti batik is one of the batiks that developed in the Surakarta Palace. This batik is a development of Sidomulyo batik which has existed since the days of the Mataram Sultanate.\n" +
                        "\n" +
                        "Sidomukti batik is a batik motif that is usually made from natural soga dye. Usually used as a cloth in wedding ceremonies."
            )
        )

        batik.add(
            BatikEntity(
                id = 10,
                name = "Batik Tambal",
                image = "https://th.bing.com/th/id/OIP.Fa8OjgvHAmgM6BXKsb_a-wAAAA?w=132&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                province = "Jawa Tengah",
                theme = "geometric",
                color = "brown",
                complexity = "high",
                island = "Jawa",
                pattern = "Batik Tambal pattern is geometrical with highly intricate detailing. The batik is composed of squares that are arranged in a grid-like formation and then inserted with multiple different patterns in each of the squares. Making what some described as beautiful and orchestrated chaos.",
                desc = "The name “tambal” has the meaning of patching, meaning patching or repairing things that are damaged. In the course of his life, humans must improve themselves towards a better life, both physically and mentally. \n" +
                        "\n" +
                        "Historically, Batik Tambal patchwork pattern was believed to help heal sick people. The trick is to cover the sick person with a Batik Tambal."
            )
        )

        batik.add(
            BatikEntity(
                id = 11,
                name = "Batik Besurek",
                image = "https://i.ibb.co/ZdgvY8z/batik-besurek.jpg",
                origin = "Sumatra",
                province = "Bengkulu",
                island = "Sumatra",
                theme = "calligraphy, flora, fauna",
                color = "brown, green, red",
                complexity = "medium",
                pattern = "Batik Besurek Arabic Calligraphy as its main motif. Batik besurek mostly use Arabic Calligraphy as its main motif, other than that Batik Besurek use other motifs such as rafflesia arnoldii / corpse flower, kuau bird, relung, and rembutan",
                desc = "Batik Besurek is a batik motif that originated from Bengkulu. The word besurek is in Bahasa Melayu with Bengkulu dialect meaning letters or writing. Based on the record from Dinas Koperasi PPKM Kota Bengkulu, batik besurek began production since 1968.\n" +
                        "\n" +
                        "Arabic calligraphy pattern came to Bengkulu from Middle Eastern and Indian traders in the 17th century. With time, Batik besurek pattern become more loose in and is mixed with various pattern in Bengkulu"
            )
        )

        batik.add(
            BatikEntity(
                id = 12,
                name = "Batik Dayak",
                image = "https://i.ibb.co/bXybRXr/batik-dayak.jpg",
                origin = "Kalimantan",
                province = "Kalimantan",
                island = "Kalimantan",
                theme = "geometric",
                color = "black, red",
                complexity = "low ~ medium",
                pattern = "Batik Datak often uses black cloth as a base for the batik. Batik Dayak uses a distinctive traditional Dayak pattern that is found in the traditional clothing of the Dayak people. The pattern is often described as tribal with geometric shapes and curves.",
                desc = "Batik Dayak is a batik that originated in the island of Kalimantan / Borneo. Dayak refer to a Dayak Ethnicity that resides on the island of Borneo for thousands of years."
            )
        )

        batik.add(
            BatikEntity(
                id = 13,
                name = "Batik Toraja",
                image = "https://i.ibb.co/b6DSR5F/batik-toraja.jpg",
                origin = "Toraja",
                province = "Sulawesi Selatan",
                island = "Sulawesi",
                theme = "geometric",
                color = "black, red",
                complexity = "low ~ medium",
                pattern = "Toraja culture is rich with ornamental patterns that later is translated into batik patterns. The pattern is often geometrical, etc, consisting of squares, circles, lines, and curves with quite a colorful assortment of colors. The colors often used are black, dark blue, red, yellow, white and orange.",
                desc = "Batik Toraja is a batik of the people of Toraja that is located on Southeast Sulawesi. \n" +
                        "\n" +
                        "The making of Batik Toraja is a bit different from other batiks. Traditionally, Batik use hot wax as a covering during the coloring process, however, Toraja people had a fabric resist dyeing technique that used rice paste (ma’a cloth) instead of hot wax."
            )
        )

        return batik
    }

    fun generateIsland(): List<IslandEntity> {
        val island = ArrayList<IslandEntity>()

        island.add(
            IslandEntity(
                id = 1,
                origin = "Jawa",
                description = "Java is an island in Indonesia and is the 13th largest island in the world. With a population of nearly 160 million, it is the most populous island in the world and one of the most densely populated places in the world. Even though it only ranks as the 5th largest, Java Island is inhabited by 60% of Indonesia's population. This figure is down when compared to the population census in 1905 which reached 80.6% of the entire population of Indonesia. The decline in population on the island of Java as a percentage is due to population movement (transmigration) from the island of Java to the rest of Indonesia. The capital city of Indonesia, Jakarta, is located in the northwestern part of Java (precisely at the westernmost end of the Pantura Line)",
                image = "https://i.ibb.co/DkxK9wW/java-final.png",
                latitude = -7.5564888,
                longitude = 110.7338442
            )
        )

        island.add(
            IslandEntity(
                id = 2,
                origin = "Sumatra",
                description = "Sumatra is the sixth largest island in the world, located in Indonesia, with an area of 473,481 km². The population of this island is around 57,940,351 (2018 census). This island is also known by other names, namely Percha Island, Andalas, or Suwarnadwipa (Sanskrit , meaning \"island of gold\"). Then in the Padang Roco Inscription in 1286, swarnnabhūmi (Sanskrit, meaning \"land of gold\") and bhūmi mālayu (\"Land of Malay\") were carved to refer to this island. Negarakertagama from the 14th century also again called \"Bumi Malayu\" (Malay) for this island." ,
                image = "https://i.ibb.co/8xm59cr/sumatra-final.png",
                latitude = -0.53196 ,
                longitude = 101.5741462
            )
        )

        island.add(
            IslandEntity(
                id = 3 ,
                origin = "Papua",
                description = "Papua or previously known as Irian or Irian Jaya, is the second largest island (after Greenland) in the world, located north of Australia. The island is divided into two regions, the western part of which is the territory of Indonesia and the eastern part is the state of Papua New Guinea. On an island that resembles a bird of paradise, lies the highest mountain in Indonesia, namely Puncak Jaya (4,884 m)",
                image = "https://i.ibb.co/p3w3gH8/papua-final.png",
                latitude = -3.9644879 ,
                longitude = 138.4865451
            )
        )

        island.add(
            IslandEntity(
                id = 4,
                origin = "Sulawesi" ,
                description = "Sulawesi is one of the four Greater Sunda Islands. It is governed by Indonesia. The world's eleventh-largest island, it is situated east of Borneo, west of the Maluku Islands, and south of Mindanao and the Sulu Archipelago. Within Indonesia, only Sumatra, Borneo and Papua are larger in territory, and only Java and Sumatra have larger populations.",
                image = "https://i.ibb.co/C00c7fR/sulawesi-final.png",
                latitude = -1.8974867,
                longitude = 120.5230474
            )
        )

        island.add(
            IslandEntity(
                id = 5,
                origin = "Kalimantan" ,
                description = "Kalimantan is the Indonesian portion of the island of Borneo. It comprises 73% of the island's area. The non-Indonesian parts of Borneo are Brunei and East Malaysia. In Indonesia, \"Kalimantan\" refers to the whole island of Borneo. In 2019, the Indonesian President Joko Widodo proposed that Indonesia's capital be moved to Kalimantan.",
                image = "https://i.ibb.co/LhGZzC0/kalimantan-final.png",
                latitude = 0.9367951,
                longitude = 114.2536418
            )
        )

        return island

    }

}