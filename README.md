# Tutorial APAP
## Authors
* **Andreas Ilham** - *1906399543* - *C*


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
