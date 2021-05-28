package com.example.batikkita.data.local

import com.example.batikkita.data.model.BatikModel
import kotlin.time.measureTime

object DummyObject {

    fun generateBatik(): List<BatikModel>{

        val batik = ArrayList<BatikModel>()

        batik.add(
            BatikModel(
                id = 1,
                name = "Batik Bali",
                origin = "Bali",
                island = "Bali",
                desc = "Batik Bali merupakan hasil penyebaran Batik dari Pulau Jawa. Bali mempunyai potensi yang besar sebagai tempat bertumbuh dan berkembangnya batik, karena masyarakat Bali diketahui secara luas mempunyai kepandaian yang tinggi dalam olah seni. Batik di Bali dibuat untuk berbagai keperluan sandang termasuk dalam upacara adat ritual keagamaan, maupun untuk Kehidupan umum sehari-hari, serta juga memenuhi kebutuhan wisatawan sebagai cinderamata."
            )
        )

        batik.add(
            BatikModel(
                id = 2,
                name = "Batik Betawi",
                origin = "Jakarta",
                island = "Jawa",
                desc = "Batik Betawi adalah kerajinan tradisional masyarakat Jakarta. Pembuatannya diawali pada abad ke-19. Motif awalnya mengikuti corak batik wilayah pesisir utara Pulau Jawa, yaitu bertemakan pesisiran. Corak batik Betawi dipengaruhi oleh kebudayaan Tiongkok. Motif batik Betawi menggunakan kaligrafi khas Timur Tengah."
            )
        )

        batik.add(
            BatikModel(
                id = 3,
                name = "Batik Celup",
                origin = "Palembang",
                island = "Sumatra",
                desc = "Batik celup adalah batik yang dibuat menggunakan teknik ikat celup. Ikat celup adalah teknik mewarnai kain dengan cara mengikat kain dengan cara tertentu sebelum dilakukan pencelupan. Di beberapa daerah di Indonesia, teknik ini dikenal dengan berbagai nama lain seperti pelangi atau cinde, tritik atau jumputan, serta sasirangan."
            )
        )

        batik.add(
            BatikModel(
                id = 4,
                name = "Batik Cendrawasih",
                origin = "Papua",
                island = "Papua",
                desc = "Batik khas papua dengan motif burung cendrawasih. Burung Cendrawasih yang fauna khas tanah Papua, memiliki bulu dan ekor yang indah. Lewat batik motif cendrawasih ini seolah menyampaikan pesan dari mana batik ini berasal. Yang mana motif yang melekat menggambarkan kedekatan dengan alam yang lebih nyata.  Warna-warna batiknya didominasi dengan warna hijau, merah, kuning yang keemasan."
            )
        )

        batik.add(
            BatikModel(
                id = 5,
                name = "Batik Gentongan",
                origin = "Madura",
                island = "Madura",
                desc = "Disebut batik gentongan karena proses pembuatannya yang menggunakan gentong sebagai alat untuk merendam kain. Teknik gentong hanya dilakukan untuk satu jenis warna saja, yaitu indigo. Teknik Gentong untuk pewarna batik hanya terdapat di dua tempat yang terletak di kecamatan Tanjung Bumi, kabupaten Bangkalan. Tidak diketahui secara pasti kapan dimulainya teknik ini di Madura. Biasanya gentong diwariskan secara turun-temurun. Hasil celupan indigo yang dilakukan pada gentong hasilnya utuh, awet, dan memiliki kepekatan merata."
            )
        )

        return batik
    }
}