package com.example.batikkita.utils

import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.IslandEntity

object DummyObject {

    fun generateBatik(): List<BatikEntity> {

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
        batik.add(
            BatikEntity(
                id = 6,
                name = "Batik Ceplok",
                image = "https://th.bing.com/th/id/OIP.nJDccL6Ie2tilSELNzUBWQAAAA?w=115&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                island = "Jawa",
                desc = "Batik ceplok atau ceplokan merupakan jenis batik yang memiliki pola atau motif dengan bentuk dasar geometri, seperti persegi, oval maupun bintang yang disusun melingkar sehingga menyerupai sekuntum bunga dengan pola simetris. Bentuk tersebut terinsirasi dari buah kawung atau buah aren yang dibelah empat."
            )
        )
        batik.add(
            BatikEntity(
                id = 7,
                name = "Batik Ciamis",
                image = "https://th.bing.com/th/id/OIP.bSirKRst-QdyTSlagsyOkAHaE8?w=269&h=180&c=7&o=5&pid=1.7",
                origin = "Jawa Barat",
                island = "Jawa",
                desc = "Batik Ciamis memiliki karakter dan corak batik yang berbeda dengan batik Garut dan Tasik. Batik ciamisan tampil sederhana tapi penuh wibawa. Kesederhaan ini tak lepas dari sejarah keberadaannya yang banyak dipengaruhi daerah lain, seperti ragam hias pesisiran dari Indramayu dan Cirebon. Selain itu, pengaruh batik nonpesisiran, seperti dari Solo dan Yogyakarta, tak kalah dominan."
            )
        )
        batik.add(
            BatikEntity(
                id = 8,
                name = "Batik Garutan",
                image = "https://th.bing.com/th/id/OIP.KlwLYLv6ccVLK1Feza4-iwHaFj?w=210&h=180&c=7&o=5&pid=1.7",
                origin = "Garut",
                island = "Jawa",
                desc = "Motif Batik Garutan selalu identik dengan motif-motif batik yang berasal dari alam pegunungan, flora dan fauna yang memiliki kaitan erat dengan keseharian masyarakat Garut terutama sebelum masa kemerdekaan. Motif Batik Garutan terinspirasi dari kondisi alam dan lingkungan masyarakat Garut sendiri, dari mulai motif batik Bulu Hayam hingga motif Lereng Kangkung."
            )
        )
        batik.add(
            BatikEntity(
                id = 9,
                name = "Batik Kawung",
                image = "https://th.bing.com/th/id/OIP.nLVR973i4AY8rMoHIb2GhAHaJ4?w=126&h=180&c=7&o=5&pid=1.7",
                origin = "Jawa",
                island = "Jawa",
                desc = "Batik Kawung adalah motif batik yang bentuknya berupa bulatan mirip buah kawung (sejenis kelapa atau kadang juga dianggap sebagai aren atau kolang-kaling) yang ditata rapi secara geometris. Kadang, motif ini juga ditafsirkan sebagai gambar bunga lotus (teratai) dengan empat lembar mahkota bunga yang merekah. Lotus adalah bunga yang melambangkan umur panjang dan kesucian."
            )
        )
        batik.add(
            BatikEntity(
                id = 10,
                name = "Batik Keraton",
                image = "https://th.bing.com/th/id/OIP.kw-895hpAhckMHz2K5PMxQHaLH?w=115&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                island = "Jawa",
                desc = "Batik keraton (dikenal juga dengan istilah batik larangan atau batik vorstenlanden) adalah batik yang berkembang dalam lingkungan keraton, baik Yogyakarta maupun Surakarta. Batik keraton merupakan awal mula dari semua jenis batik yang berkembang di Indonesia. Motifnya mengandung beragam makna filosofi hidup yang banyak terilhami dari kebudayan Hindu-Jawa. Batik-batik ini dibuat oleh para putri keraton dan juga pembatik-pembatik ahli yang hidup di lingkungan keraton. Pada dasarnya motifnya terlarang untuk digunakan oleh orang “biasa” seperti motif Batik Parang Barong, Batik Parang Rusak termasuk Batik Udan Liris, dan beberapa motif lainnya."
            )
        )

        batik.add(
            BatikEntity(
                id = 11,
                name = "Batik Lasem",
                image = "https://th.bing.com/th/id/OIP.EioGZ1j5nehrrt66gbAcAAHaFj?w=213&h=180&c=7&o=5&pid=1.7",
                origin = "Jawa",
                island = "Jawa",
                desc = "Batik lasem adalah batik nusantara hasil perpaduan dari dua budaya yakni Tionghoa dan Jawa. Secara umum, batik ini memiliki dua motif utama, yakni motif Tionghoa dengan gambar burung hong, naga, ayam hutan, dan sebagainya, sedangkan motif non-Tionghoa bergambar sekar jagad, kendoro kendiri, kricak, grinsing, dan lainnya. Batik lasem juga dikenal sebagi batik tiga negeri karena memiliki tiga kali proses pewarnaan di tiga tempat berbeda. Warna merah di Lasem, biru di Pekalongan, dan Cokelat di Solo."
            )
        )

        batik.add(
            BatikEntity(
                id = 12,
                name = "Batik Megamendung",
                image = "https://th.bing.com/th/id/OIP.rCcIsuRjhanzIjw9lg3uoQHaHa?w=198&h=198&c=7&o=5&pid=1.7",
                origin = "Cirebon",
                island = "Jawa",
                desc = "Motif batik Megamendung merupakan karya seni batik yang identik dan bahkan menjadi ikon batik daerah Cirebon dan daerah Indonesia lainnya. Motif batik ini mempunyai kekhasan yang tidak ditemui di daerah penghasil batik lain. Bahkan karena hanya ada di Cirebon dan merupakan mahakarya, Departemen Kebudayaan dan Pariwisata akan mendaftarkan motif megamendung ke UNESCO untuk mendapatkan pengakuan sebagai salah satu warisan dunia."
            )
        )

        batik.add(
            BatikEntity(
                id = 13,
                name = "Batik Parang",
                image = "https://th.bing.com/th/id/OIP._kf_2DziiUGc-r5J2o39fgHaD4?w=339&h=181&c=7&o=5&pid=1.7",
                origin = "Jawa",
                island = "Jawa",
                desc = "Batik Parang merupakan salah satu motif batik yang paling tua di Indonesia. Parang berasal dari kata Pereng yang berarti lereng. Perengan menggambarkan sebuah garis menurun dari tinggi ke rendah secara diagonal. Susunan motif S jalin-menjalin tidak terputus melambangkan kesinambungan."
            )
        )

        batik.add(
            BatikEntity(
                id = 14,
                name = "Batik Pekalongan",
                image = "https://th.bing.com/th/id/OIP.fiEyAQq72r73-Yhwh4rP4QAAAA?w=142&h=190&c=7&o=5&pid=1.7",
                origin = "Pekalongan",
                island = "Jawa",
                desc = "Batik Pekalongan termasuk batik pesisiran. Dari sisi motif, sebenarnya batik Pekalongan mirip dengan batik Solo maupun Yogyakarta. Keunggulan batik Pekalongan terletak pada penggunaan warna. Sehelai kain batik bisa menggunakan delapan warna sehingga terlihat lebih indah dan menarik dibanding batik-batik dari daerah lain"
            )
        )

        batik.add(
            BatikEntity(
                id = 15,
                name = "Batik Priangan",
                image = "https://th.bing.com/th/id/OIP.ByRn0OmN0M3R1UzJr2hmTAAAAA?w=187&h=125&c=7&o=5&pid=1.7",
                origin = "Jawa Barat",
                island = "Jawa",
                desc = "Batik yang berasal dari Jawa barat ini biasa disebut dengan batik Priangan, istilah ini digunakan untuk memberikan identitas pada berbagai batik yang dihasilkan dan berlangsung di Priangan. Secara keseluruhan, kesan yang didapat saat melihat selembar batik priangan adalah kesan cantik-molek, bahkan sedikit genit, yang mungkin selaras dengan citra orang Sunda."
            )
        )

        batik.add(
            BatikEntity(
                id = 16,
                name = "Batik Sekar",
                image = "https://th.bing.com/th/id/OIP._jdwFac0FHn7EUxlC3YpnwHaD4?w=310&h=180&c=7&o=5&pid=1.7",
                origin = "Jawa",
                island = "Jawa",
                desc = "Batik Sekar Jagad adalah salah satu motif batik khas Indonesia. Motif ini mengandung makna kecantikan dan keindahan sehingga orang lain yang melihat akan terpesona. Ada pula yang beranggapan bahwa motif Sekar Jagad sebenarnya berasal dari kata \"kar jagad\" yang diambil dari bahasa Jawa (Kar=peta; Jagad=dunia), sehingga motif ini juga melambangkan keragaman di seluruh dunia."
            )
        )

        batik.add(
            BatikEntity(
                id = 17,
                name = "Batik Sidoluhur",
                image = "https://th.bing.com/th/id/OIP.qGMHD6toLUR8tnrG_v8quQHaEN?w=259&h=183&c=7&o=5&pid=1.7",
                origin = "Jawa",
                island = "Jawa",
                desc = "Batik Sidoluhur adalah salah satu motif batik pedalaman yang cukup populer. Sesuai dengan namanya, motif ini bermakna harapan untuk mencapai kedudukan yang tinggi dan dapat menjadi panutan masyarakat (keluhuran). Motif-motif batik berawalan sida (dibaca sido) merupakan golongan motif yang banyak dibuat para pembatik. Kata “sida” dalam bahasa Jawa sendiri berarti jadi/menjadi/terlaksana. Dengan demikian, motif-motif berawalan “sida” mengandung harapan agar apa yang diinginkan bisa tercapai."
            )
        )

        batik.add(
            BatikEntity(
                id = 18,
                name = "Batik Sidomukti",
                image = "https://th.bing.com/th/id/OIP.xS3cJXJ-lmMhxBG8vUiavQHaHa?w=166&h=180&c=7&o=5&pid=1.7",
                origin = "Jawa",
                island = "Jawa",
                desc = "batik Sidomukti meruapakan motif batik yang biasanya terbuat dari zat pewarna soga alam. Biasanya digunakan sebagai kain dalam upacara perkawinan. Unsur motif yang tekandung didalamnya adalah gurda. Motif-motif berawalan sida (dibaca sido) merupakan golongan motif yang banyak dibuat para pembatik. Kata “sida” sendiri berarti jadi/menjadi/terlaksana. Dengan demikian, motif-motif berawalan “sida” mengandung harapan agar apa yang diinginkan bias tercapai. Salah satunya adalah sida mukti, yang mengandung harapan untuk mencapai kebahagiaan lahir dan batin."
            )
        )

        batik.add(
            BatikEntity(
                id = 19,
                name = "Batik Sogan",
                image = "https://th.bing.com/th/id/OIP.jkZwvj9-ZouD8m7VBtLLlwHaJ4?w=124&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                island = "Jawa",
                desc = "Batik Sogan merupakan salah satu jenis batik bernuansa klasik variasi warna didominasi warna coklat. Dinamakan batik sogan karena pada awal mulanya, proses pewarnaan batik ini menggunakan pewarna alami yang diambil dari batang kayu pohon soga tingi. Batik Sogan identik dengan daerah keraton Jawa seperti Yogyakarta dan Solo, motifnya pun biasanya mengikuti pakem motif-motif klasik keraton."
            )
        )

        batik.add(
            BatikEntity(
                id = 20,
                name = "Batik Tambal",
                image = "https://th.bing.com/th/id/OIP.Fa8OjgvHAmgM6BXKsb_a-wAAAA?w=132&h=180&c=7&o=5&pid=1.7",
                origin = "Yogyakarta",
                island = "Jawa",
                desc = "Motif batik tambal memiliki arti tambal bermakna menambal atau memperbaiki hal-hal yang rusak. Dalam perjalanan hidupnya, manusia harus memperbaiki diri menuju kehidupan yang lebih baik, lahir maupun batin. Dahulu, kain batik bermotif tambal dipercaya bisa membantu kesembuhan orang yang sakit. Caranya adalah dengan menyelimuti orang sakit tersebut dengan kain motif tambal."
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
                description = "Jawa adalah sebuah pulau di Indonesia dan merupakan pulau terluas ke-13 di dunia. Dengan jumlah penduduk sekitar hampir 160 juta, pulau ini pulau berpenduduk terbanyak di dunia dan merupakan salah satu tempat terpadat di dunia. Meskipun hanya menempati urutan terluas ke-5, Pulau Jawa dihuni oleh 60% penduduk Indonesia. Angka ini turun jika dibandingkan dengan sensus penduduk tahun 1905 yang mencapai 80,6% dari seluruh penduduk Indonesia. Penurunan penduduk di Pulau Jawa secara persentase diakibatkan perpindahan penduduk (transmigrasi) dari pulau Jawa ke seluruh Indonesia. Ibu kota Indonesia, Jakarta, terletak di Jawa bagian Barat Laut (tepatnya di ujung paling barat Jalur Pantura)." ,
                image = "https://uc8e6dcb4d49a23412d60e074ad3.previews.dropboxusercontent.com/p/thumb/ABJqBGwV6IDkfM8Y4TPsefJktrtbEPMi4Wt9rekbzJHf7nqjkeOGDRTQjUQv1J4Z55de3HrkEFbVx_EhbqEDoeigXvRVWgFk_OuHRYXgMe93wzCabZvLXvqrtSNYQqH78YCin0seMjq6vS3kd2jl6NSGciGfXwgFXnhqNl4dgjKcs-EI6D-6IFtzI5-0j4C93hCVOL7bovuxWr1n1XR-jos_JO5z-MpKchFTUnK0NAZ2K8aYoDzHhdcXrDE20apsn_GdSBThm7PYef7u3CqimTDbQShFhqu4-SQIstmyij4wKD03MUHMjoTHbD9TD5rxAbR7P2d-7CMnGwu7l8eqZVAqgLr8HoOm1sh5I9NCNro7sdcMaQGlXxG65lO-WgstyJSllfsjbndU_JaNubS7KB0N/p.png?fv_content=true&size_mode=5",
                latitude = -7.5564888,
                longitude = 110.7338442
            )
        )

        island.add(
            IslandEntity(
                id = 2,
                origin = "Bali",
                description = "Bali adalah sebuah provinsi di Indonesia yang ibu kota provinsinya bernama Denpasar. Bali juga merupakan salah satu pulau di Kepulauan Nusa Tenggara. Di awal kemerdekaan Indonesia, pulau ini termasuk dalam Provinsi Sunda Kecil yang beribu kota di Singaraja, dan kini terbagi menjadi 3 provinsi, yakni Bali, Nusa Tenggara Barat, dan Nusa Tenggara Timur.[9][10] Pada tahun 2020, penduduk provinsi Bali berjumlah 4.317.404 jiwa, dengan kepadatan 747 jiwa/km2",
                image = "https://uc1bd084ea79725b289f19f824ce.previews.dropboxusercontent.com/p/thumb/ABJKJrttFbkufAMuOQ_32TfLVIC9x2V7xO8ohrImJpMFj07HbqE6okj1XtdKJr-ehMm2JyhL4uoLY-2knkrIFS4DZYhelFg-f4X-28b9OIQnv1esTgp1h3B7jq28HDhMwQPb3igdbF0DZYqowQxOlK2pur_vWbEBssGP5a4GC2M0pgSKYFegPoMTKTIgncTORIb0SxekEsrGAxV5IWb7Txv3PxS-W2_88BhCVTkmjn_GtK3kIAq66Qm2afSZLWAzw64s6fxTA9F0e1hWEa1qQhctsMLR8aCs_6Afgq8jJDFw28lFeU7J9cgEDdUxsUVgIMEE-UfmgIXSnyt32RjzPvS2k8gfNGgyi0EgJi7TDwABiUhW8eSmKJxlrQjlLNShFnR95RadX_OArshtef0y4bqx/p.png?size=1600x1200&size_mode=3",
                latitude = -8.3627798 ,
                longitude = 115.1370432
            )
        )

        island.add(
            IslandEntity(
                id = 3,
                origin = "Sumatra",
                description = "Sumatra adalah pulau keenam terbesar di dunia yang terletak di Indonesia, dengan luas 473.481 km². Penduduk pulau ini sekitar 57.940.351 (sensus 2018). Pulau ini dikenal pula dengan nama lain yaitu Pulau Percha, Andalas, atau Suwarnadwipa (bahasa Sanskerta, berarti \"pulau emas\"). Kemudian pada Prasasti Padang Roco tahun 1286 dipahatkan swarnnabhūmi (bahasa Sanskerta, berarti \"tanah emas\") dan bhūmi mālayu (\"Tanah Melayu\") untuk menyebut pulau ini. Selanjutnya dalam naskah Negarakertagama dari abad ke-14 juga kembali menyebut \"Bumi Malayu\" (Melayu) untuk pulau ini." ,
                image = "https://ucc6e1084ec389b6201f9e3bc0cc.previews.dropboxusercontent.com/p/thumb/ABLdbdosqmBTkmvGtPrnNQbED0LKa6AfVOT344Jt0LseHKoJ3YqK39tfsSwzQqpCMU2uOjKkQePwvRiX_RMCfhYwyr0-aqTtFgO2J8qajB0Ix434GqRZKvn6JhWA3y0BLT9acMFRdQgMy2etPKexKBK3h-PoYNRoRng3iwlSlDKknAOnsfQ7HmSQG14fIkRsjpUNN9TCVy0RKbpnzydRk8ZUGeNFAbkLLnMTFUtCj9bVFITmwvJvxNHACUAssOhbxWDrXz4O-S9mYbdoU0oh5RIqlFyxof0NhAwASuczvz8HbfM6Ug3Qg5OGyomNgnKeB7F15IJsn3yrJHjv4yQpvL_gtM6m0jeJ2lfUGUY0MsVaEUDteiQvuKOXn2DtxGas3lfu-MCXgnw4uw0MDrqiabR-/p.png?fv_content=true&size_mode=5" ,
                latitude = -0.53196 ,
                longitude = 101.5741462
            )
        )

        island.add(
            IslandEntity(
                id = 4 ,
                origin = "Papua",
                description = "Papua atau yang dulu disebut dengan Irian atau Irian Jaya, adalah pulau terbesar kedua (setelah Greenland) di dunia yang terletak di sebelah utara Australia. Pulau ini dibagi menjadi dua wilayah yang bagian baratnya merupakan wilayah Indonesia dan bagian timurnya merupakan negara Papua Nugini. Di pulau yang bentuknya menyerupai burung cendrawasih ini terletak gunung tertinggi di Indonesia, yaitu Puncak Jaya (4.884 m)",
                image = "https://uc36cb4bbc150e7795a17dff7962.previews.dropboxusercontent.com/p/thumb/ABKrt9h8m2cC1wGxx1QZGeAtI1eXVNwvcCN65YNxBFYWaO5jUGQxceBx6rnr1X2qXuFfJwNJWzxdnyRGynnqyTaVxEDtwv520gDcnRPwlDjMIvCNpma7TfCLDA_G0ncIU1mQpg4uAZkt8oj7ZrRoNU0TWsR0TQIdUOimFFUZ57xjs0lRW9FSXhglaJOKCCgHXebGLGb9PUyQPbEzKloX0aOhU1F6I8UoXkUTg69XVHdKE5ZD_iCHNic54j_w_FSe8lHgiIpgJ_yvqBqwU1nUrHYKxI4bWR_lL5zCUmJfkwwQu2FLZHwliEXI7zzDyhi-l_ExPQxU5gRC8MiSVTkbtJsSjN0OiLuhOYuIYIfljtsmpBP07KaXtmjIc7Lc3Jrm4k6vUD2skYdwioTfuy4vMjng/p.png?fv_content=true&size_mode=5",
                latitude = -3.9644879 ,
                longitude = 138.4865451
            )
        )

        island.add(
            IslandEntity(
                id = 5,
                origin = "Madura" ,
                description = "Madura adalah nama pulau yang terletak di sebelah timur laut Jawa Timur. Pulau Madura besarnya kurang lebih 5.168 km2 (lebih kecil daripada pulau Bali), dengan penduduk hampir 4 juta jiwa. Pulau Madura bentuknya seakan mirip badan sapi, terdiri dari empat Kabupaten, yaitu: Bangkalan, Sampang, Pamekasan dan Sumenep. Madura, Pulau dengan sejarahnya yang panjang, tercermin dari budaya dan keseniannya dengan pengaruh islamnya yang kuat.",
                image = "https://uc92550840b808b83a7e635e47c3.previews.dropboxusercontent.com/p/thumb/ABLSy-HBsfJm8TdbC4qro2g-iq6XeAZoIIZSms777Ur_MnYVW6Lk3a3aBtnCYWgop-F11-0LaIw-sxk_N-WU6P7KGCc1NJNdTpOZ1VXm8XckfVoYv8p4OGQLBNzn3Eqy9q3kNo8rQDLYT4Y5tDe9HLXSWZ8DM_RmeFHqrlYDqH49PfelFNM2LRbwmRHGTfYICXLfq0WVMONIh_t1x8DUmcjGHcOq4dcCZYAiENMb4VsBmu8PINa_bXkdd9T7QkCDzc8R86r7Qg0nUsDWM4RtCwaYrOKLhUDyqcPe49Z2uc_C-ipnZ6uq1MzyxfUZNZnf-WDVUfPLfPD59E2fCP6aRoqPzbzCabhpvnwMGQxv8anDn-XYvQvx_O0uTotiMTOOMTeRmsMtp9bCltiY-RWJyCq0/p.png?size=1600x1200&size_mode=3",
                latitude = -7.0576888,
                longitude = 113.2607462
            )
        )

        return island

    }

    fun getByName(name: String) : String {
        var image = ""
        for (i in generateBatik()) {
            if (i.name == name) {
                image = i.image
            }

        }
        return image
    }

}