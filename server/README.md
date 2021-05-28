1. build image
```bash
docker build -t server_sleaf:latest .
```

2. run container
```bash
docker container run -p 5000:5000 -e FLASK_APP=sleaf.py -e LC_ALL=C.UTF-8 -e LANG=C.UTF-8 -e FLASK_ENV=deployment -it server_sleaf flask run --host=0.0.0.0
```
URL bisa diakses:
- http://127.0.0.1:5000 : halaman utama dummy (lewat browser)
- http://127.0.0.1:5000/random : API untuk random tanaman -> response : info tanaman random
- http://127.0.0.1:5000/upload : API predict image -> response: info tanaman


RESPONSE
contoh:
```json
{
    "class_name": "Alpinia Galanga (Lengkuas)",
    "name": "Lengkuas",
    "desc": "Lengkuas, laos atau kelawas merupakan jenis tumbuhan umbi-umbian yang bisa hidup di daerah dataran tinggi maupun dataran rendah. Umumnya masyarakat memanfaatkannya sebagai campuran bumbu masak dan pengobatan tradisional.",
    "scientific_name": "Alpinia galanga",
    "img_urls": [
        "https://prasetio23.files.wordpress.com/2015/01/download-3.jpg",
        "https://foto.kontan.co.id/taUhIcxCd3YrdcwZsCFbmDGa1sw=/smart/2020/06/11/553414440p.jpg"
    ]
}
```