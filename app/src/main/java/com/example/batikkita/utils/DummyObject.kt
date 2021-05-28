package com.example.batikkita.utils

import com.example.batikkita.data.source.local.entity.BatikEntity

object DummyObject {

    fun generateBatik(): List<BatikEntity>{

        val batik = ArrayList<BatikEntity>()

        batik.add(
            BatikEntity(
                id = 1,
                name = "Batik Bali",
                image = "https://th.bing.com/th/id/OIP.QNPbs5LrdEPuK5D9t8Aw9AHaFj?w=218&h=180&c=7&o=5&pid=1.7",
                origin = "Bali",
                island = "Bali",
                desc = "Batik Bali merupakan hasil penyebaran Batik dari Pulau Jawa. Bali mempunyai potensi yang besar sebagai tempat bertumbuh dan berkembangnya batik, karena masyarakat Bali diketahui secara luas mempunyai kepandaian yang tinggi dalam olah seni. Batik di Bali dibuat untuk berbagai keperluan sandang termasuk dalam upacara adat ritual keagamaan, maupun untuk Kehidupan umum sehari-hari, serta juga memenuhi kebutuhan wisatawan sebagai cinderamata."
            )
        )

        batik.add(
            BatikEntity(
                id = 2,
                name = "Batik Betawi",
                image = "https://th.bing.com/th/id/OIP.tHieZBhdakzYtx8PFIuf4AAAAA?w=201&h=141&c=7&o=5&pid=1.7",
                origin = "Jakarta",
                island = "Jawa",
                desc = "Batik Betawi adalah kerajinan tradisional masyarakat Jakarta. Pembuatannya diawali pada abad ke-19. Motif awalnya mengikuti corak batik wilayah pesisir utara Pulau Jawa, yaitu bertemakan pesisiran. Corak batik Betawi dipengaruhi oleh kebudayaan Tiongkok. Motif batik Betawi menggunakan kaligrafi khas Timur Tengah."
            )
        )

        batik.add(
            BatikEntity(
                id = 3,
                name = "Batik Celup",
                image = "https://th.bing.com/th/id/OIP.RV-MWaCMl2z7QFX1v89hdAHaFE?w=247&h=180&c=7&o=5&pid=1.7",
                origin = "Palembang",
                island = "Sumatra",
                desc = "Batik celup adalah batik yang dibuat menggunakan teknik ikat celup. Ikat celup adalah teknik mewarnai kain dengan cara mengikat kain dengan cara tertentu sebelum dilakukan pencelupan. Di beberapa daerah di Indonesia, teknik ini dikenal dengan berbagai nama lain seperti pelangi atau cinde, tritik atau jumputan, serta sasirangan."
            )
        )

        batik.add(
            BatikEntity(
                id = 4,
                name = "Batik Cendrawasih",
                image = "https://th.bing.com/th/id/OIP.RDJVl1HPex2N5L5BkSUHtwAAAA?w=185&h=186&c=7&o=5&pid=1.7",
                origin = "Papua",
                island = "Papua",
                desc = "Batik khas papua dengan motif burung cendrawasih. Burung Cendrawasih yang fauna khas tanah Papua, memiliki bulu dan ekor yang indah. Lewat batik motif cendrawasih ini seolah menyampaikan pesan dari mana batik ini berasal. Yang mana motif yang melekat menggambarkan kedekatan dengan alam yang lebih nyata.  Warna-warna batiknya didominasi dengan warna hijau, merah, kuning yang keemasan."
            )
        )

        batik.add(
            BatikEntity(
                id = 5,
                name = "Batik Gentongan",
                image = "https://th.bing.com/th/id/OIP.XSDI9yMTSOnbpjlLMLfBNwHaFj?w=202&h=180&c=7&o=5&pid=1.7",
                origin = "Madura",
                island = "Madura",
                desc = "Disebut batik gentongan karena proses pembuatannya yang menggunakan gentong sebagai alat untuk merendam kain. Teknik gentong hanya dilakukan untuk satu jenis warna saja, yaitu indigo. Teknik Gentong untuk pewarna batik hanya terdapat di dua tempat yang terletak di kecamatan Tanjung Bumi, kabupaten Bangkalan. Tidak diketahui secara pasti kapan dimulainya teknik ini di Madura. Biasanya gentong diwariskan secara turun-temurun. Hasil celupan indigo yang dilakukan pada gentong hasilnya utuh, awet, dan memiliki kepekatan merata."
            )
        )

        return batik
    }
}