# Tutorial APAP
## Authors
* **Andreas Ilham** - *1906399543* - *C*

## Tutorial 7

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
> pada latihan nomor 1, saya membuat sebuah function handledeleteitemforcart yang berisi proses penambahan balance dari item yang dihapus di dalam keranjang. Setelah itu apabila icon deletenya diklik, maka file di dalam inchart akan menjadi false
![Nomor 1](frontend/img/soal_1.png)
> pada latihan nomor 2, saya membuat dua buah function yang ngehandle apabila item dimasukkan ke dalam keranjang maka balancenya akan dikurangi harga barang dan apabila item dikeranjang dihapus maka balancenya akan ditambahkan sesuai harga item
![Nomor 2](frontend/img/soal_2.png)
> pada latihan nomor 3, apabila sisa balance yang ada kurang dari harga barang yang akan dimasukkan ke dalam keranjang, maka akan muncul pop up alert yang menampilkan balance is not sufficient "foto kodingan sama kaya nomor 2"

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
> State merupakan data private sebuah komponen yang hanya dibuat untuk komponen itu sendiri dan tidak bisa digunakan oleh komponen lain. Props merupakan properti dari class yang hanya diakses melalui keyword 'this' dan props fungsinya mirip dengan attribute pada tag di dalam HTML.

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
> Dengan component, kita bisa memanggil lagi dimanapun kita butuh karena setiap components punya logika sendiri dan mengontrol logika sendiri. Penggunaan kode secara berulang membantu membuat aplikasi kita jadi mudah untuk dipelihara dan dipelihara.

4. Apa perbedaan class component dan functional component?
> Class component digunakan ketika akan melakukan extend dari React.Component serra membuat function render. Functional component juga tidak menggunakan state sedangankan class component iya.

5. Dalam react, apakah perbedaan component dan element?
> perbedaan yang ada pada component dan element terletak pada input yang diterima. Function menerima input parameter dan me-return nilai sedangkan komponen menerima input props dan mereturn react element.

## Tutorial 6

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
> Otentikasi verifikasi tujuannya adalah untuk memeriksa detail dari pengguna dengan tujuan untuk mengidentifikasi serta memberikan akses ke sistem, sedangkan otorisasi adalah proses untuk melakukan pengecekan izin pengguna yang diotentikasi untuk sistem bagian spesifik
> Konsep tersebut diimplementasikan pada class WebSecurityConfig yang mana otentikasi diaplikasikan pada bagian: @Autowired public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{auth.userDetailsService(userDetailsService).passwordEncode(encoder());}. Bagian otorisasi diaplikasikan seperti: .antMatchers("/css/").permitAll(), .antMatchers("/user/addU").hasAuthority("ADMIN")

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
> BCryptPasswordEncoder adalah fungsi yang digunakan untuk mengenkripsi sehingga password tidak diketahui walaupun sudah dilihat di database. 

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
> Untuk menyimpan password sebaiknya kita menggunakan hashing karena hashing sendiri merupakan one-way function yang mana hash tidak lagi bisa dikembalikan ke bentuk awal. Sedangkan encryption bersifat reversible yang mana kita bisa mendapatkan value dari encryption melalui proses decryption. Biasanya Decryption digunakan untuk menjaga data agar tetap aman sampai ke tujuan.

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
> UUID digunakan untuk mengecek beberapa objek atau entitas di internet secara unik. UUID digunakan untuk keamanan data dari pengguna karena id pengguna akan digenerate secara random dan unik sehingga id aman dan tidak dapat diretas

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?
> Kegunaan UserDetailsService adalah sebagai inti dalam kerangka kerja Spring Security, yang nantinya digunakan ketika akan mengambil informasi otentikasi dan otorisasi pengguna.

## Tutorial 5

1. Apa itu Postman? Apa kegunaannya?
> Postman adalah aplikasi/tool open source untuk dokumentasi dan test API. Postman bermanfaat untuk dokumentasi API, test API, sharing himpunan API, dan kolaborasi penciptaan API. Postman sangat membantu dan mempermudah dalam mengerjakan testing karena kita tidak harus menggunakan code yang berlebihan terlebih dahulu untuk sekadar mengerjakan testing suatu fungsi atau output API.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty. 
> @JsonIgnoreProperties memanggil property dalam class yang di-ignore. Dapat juga digunakan untuk meng-ignore unknown property. @JsonProperty bekerja untuk memberikan tanda pengenal agar jackson object mapper bisa memvisualkan JSON property ke attribute/tujuan dalam java.

3. Apa kegunaan atribut WebClient?
> Atribut WebClient bermanfaat untuk meninggalkan method untuk memindahkan dan meyakini data dari resource yang diidentifikasi oleh URI.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
> ResponseEntity menggambarkan HTTP response berupa header, body, dan status. ResponseEntity bisa digunakan untuk struktur secara sempurna HTTP response. BindingResult mengandung validasi dan binding dan mengandung error yang mungkin terjadi. BindingResult tampil tepat setelah tujuan divalidasi. BindingResult bisa digunakan untuk memeriksa error yang terjadi pada validasi form yang berasal dari pengguna dan menyimpan hasilnya.

## Tutorial 4

1. Jelaskan perbedaan th:include dan th:replace!
> Fragmen merupakan bagian kecil kode yang bisa disertakan di dalam template lain. Ini merupakan praktik yang biasa pada pengembangan web dalam menciptakan komponen kecil yang bisa dipakai lagi misalnya header, footer, menu navigasi, & bagian lain dari situs web yang dipakai berulang kali dalam beberapa page. Seperti yang kita ketahui, Thymeleaf bisa menyertakan bagian-bagian dari page lain menjadi fragmen. Terdapat atribut-atribut dalam Thymeleaf yang bisa kita pakai berdasarkan kebutuhan. `th:include` & `th:replace` adalah contohnya. 
> Perbedaan berdasarkan keduanya yaitu atribut `th:include` akan memasukkan fragmen yang disiapkan menjadi body dalam tag host-nya, namun tag fragmen-nya tidak ikut dimasukkan. Singkatnya, `th:include` akan **menyertakan isi** berdasarkan fragmen ke pada tag host-nya.
> Sedangkan, atribut `th:replace` akan menghapus lalu menggantikan tag host, kemudian menambahkan fragmen yang ditentukan, termasuk tag fragmen itu sendiri. Singkatnya, `th:replace` akan **menggantikan** tag host-nya menggunakan fragmen.

2. Jelaskan apa fungsi dari th:object!
> `th:object` adalah atribut yang berfungsi dalam meng-handle form input berdasarkan user. `th:object` menyimpan command object (bentuk representasi berdasarkan objek yang berada dalam backend). `th:object` dipakai buat **memilih objek model** yang akan dipakai buat mengumpulkan data form.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
> Pada Thymeleaf, `*` dinamakan asterisk syntax dan `$` dinamakan dollar syntax yang keduanya dipakai dalam melakukan variable expression. Perbedaan berdasarkan asterisk syntax dan dollar syntax merupakan asterisk syntax mengevaluasi ekspresi dalam objek yang dipilih, bukan dalam semua atribut / variable maps. Sedangkan, dollar syntax akan mengevaluasi ekspresi dalam semua atribut. Jadi, selama tidak terdapat objek yang dipilih, dollar syntax dan asterisk syntax akan melakukan hal yang persis sama.

## Tutorial 3

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

> @AllArgsConstructor: Model yang digunakan untuk men-generate sebuah constructor dengan 1 parameter saja
> @NoArgsConstructor: Model yang digunakan untuk men-generate sebuah contructor yang tidak memiliki parameter. Apabila memiliki parameter, compiler akan mengeluarkan error message
> @Setter: Sebuah anotasi dan lombok akan men-generate setter secara otomatis
> @Getter: Sebuah anotasi dan lombok akan men-generate getter secara otomatis
> @Entity: Model yang mengindikasikan sebuah class secara abstrak yang berkolerasi dengan sebuah tabel pada database
> @Table: Anotasi yang menspesifikasi detail sebuah tabel yang akan digunakan untuk entity pada database.

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method
tersebut?

> Method findByNoBioskop adalah metode yang digunakan untuk melakukan fetch pada bioskop melalui paramter no bioskop tersebut. Metode yang diawali dengan "findby" merupakan metode dari modul JPARespository yang akan diikuti dengan object variablesnya, dimana pengambilan data didasari oleh variabel tersebut.

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn

> @JoinTable merupakan model yang digunakan untuk membuat tabel baru dengan sebuah relationship antartabel berbeda.
> @JoinColumn merupakan model yang digunakan untuk membuat kolom baru dengan sebuah relationship antarkolom berbeda.

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull

> name digunakan sebagai kolom untuk primary key, referencedColumnName merupakan kolom yang dituju atau direferensikan, dan nullable mendefiniskan value yang undefined/di-aaign sebagai null.
>Perbedaan antara anotasi @NotNull dan nullable yaitu untuk @NotNull digunakan untuk mendefinisikan method yang tidak mereturn null sedangkan nullable digunakan dalam memanggil method yang dapat me-return null, dan deferencing variable yang bisa bernilai null

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

> FetchType.LAZY merupakan metode untuk mengambil sebuah child pada sebuah class dengan mengambil proxy dari entity child.
>CascadeType.ALL merupakan sebuah metode propagasi/cascade semua operasi EntityManager untuk enity berhubungan.
>FetchType.EAGER merupakan metode mengambil entity child dengan parentnya

## Tutorial 2

1. Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

> Akan muncul error dan link tersebut tidak dapat dibuka karena pada tahap ini, masih belum ada file html yang akan menampilkan hasil dari run program tersebut.

2. Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

> anotasi @Autowired akan melihat isi dari package yang telah dibuat lalu akan mememberikan anotasi kepada class-class yang ada dan setelah itu akan mnginisiasi class tersebut. @Autowired pada controller akan mengambil isi dari service sehingga pada controller dapat memanggil fungsi yang ada pada service

3. Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

> Akan muncul Error karena inputan tersebut tidak akan masuk ke dalam data karena terdapat kurang satu informasi yaitu jumlah studio

4. Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?

> http://localhost:8080/bioskop/view/nama-bioskop/Bioskop%20Maung.

5. Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

> Apabila data yang diinput sesuai dengan yang diminta, maka inputan akan berhasil dan hasil yang akan muncul, sesuai dengan screenshot yang terlampir pada drive.
>link drive: https://ristek.link/APAP-no-5


Referensi: https://software.endy.muhardin.com/java/memahami-dependency-injection/

---------------------------------------------------------------------------------------

=======
## Tutorial 1
### What I have learned today

>Pada tutorial kali ini saya mempelajari banyak hal yang sebelumnya tidak saya ketahui. Bermula dari menyiapkan git lalu menyiapkan folder dan file yang nantinya diperlukan di dalam directory. Pada awal tutorial saya juga mempelajari revert yang mana itu dapat membantu kita ketika ingin mengembalikan commit ke keadaan sebelumnya. Setelah itu saya mempelajari bagaimana cara membuat repository di Github yang akan digabungkan dengan lokal repository. Selain itu saya mempelajari juga apa itu branch, bagaimana membuat branch, spring boot, serta mempelajari mengenai penggunaan intellij

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
>Issue Tracker sebuah softwarre yang mencatat masalah yang dialami pelanggan dengan software product, dan memungkinkan support agents, teknisi, dan manajer untuk melacak masalah tersebut sampai masalah tersebut berhasil diselesaikan.

2. Apa perbedaan dari git merge dan git merge --squash?
> Git merge adalah suatu command dalam git untuk membuat branch yang bercabang menjadi satu kembali atau dengan kata lain mengintegrasikan kembali branch tersebut menjadi satu. Pada git merge --squash, semua perubahan yang ada akan di menjadi sebuah commit sedangkan pada git merge akan ditampilkan semua perubahan-perubahannya

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
> - Mendukung dalam pengembangan non-linear(pengembanganparalel)
> - Mendukung dalam proyek besar seperti Kernel Linux
> - Akses hanya menggunakan command line tanpa memerlukan client server
> - Penyimpanan murni berbasis file (tidak menggunakan database/SQL)
> - Open Source alias Gratis
> - Mampu menangani sejumlah remote repository dengan baik
> - Dapat melihat dengan jelas pada tahap mana kita melakukan kesalahan

### Spring
4. Apa itu library & dependency?
> library: kumpulan class dan functions yang disediakan Spring yang memiliki fungsi sehingga dapat dipanggil ke dalam program lain. Library membantu kita untuk membuat sebuah dependency
> dependency: suatu ketergantungan seperti sebuah class yang terikat dengan class yang lainnya. Depedency berisikan library. Jika ingin menggunakan library, kita harus menaruh dependency di POM.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
> Maven adalah alat manajemen proyek yang didasarkan POM (project object model) yang digunakan untuk mempermudah pembangunan dan pengelolaan proyek serta dependency dan dokumentasinya. Kita menggunakan maven agar dapat menambahkan semua dependensi yang diperlukan untuk proyek secara otomatis dengan membaca file pom. Ada beberapa alternatif yaitu CMake, GNU Make, Gradle,dll. Ada beberapa alternatif yaitu CMake, GNU Make, Gradle,dll

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
> Spring framework menggunakan teknik pemograman yang sederhana, model pemograman dengan Spring cukup mudah, namun rapi. Spring termasuk framework yang lightweight (ringan) untuk mendukung secara penuh dalam pengembangan aplikasi Enterprise siap pakai. Spring dapat digunakan untuk membuat aplikasi enterprise, pengembangan software, membuat bot, dan mengembangkan application testing.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
> Anotasi @PathVariable digunakan untuk data yang diteruskan di URI (misalnya, RESTful web services) dan dapat digunakan dalam RequestMethod. Sementara @RequestParam digunakan untuk mengekstrak data yang ditemukan dalam query parameter. @RequestParam digunakan untuk pencarian yang lebih eksklusif.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Materi apa saja yang dapat membantu saya pada lab selanjutnya?
