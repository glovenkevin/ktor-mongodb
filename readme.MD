# Ktor with MongoDB

This is my project for learning mongoDB using ktor application
and docker as deployment. 

# Example Data

Use this JSON to fill up your database

Request
- method: POST
- endpoint: `/v1/barang/insertMass`
- body:

```json
{
  "data": [
    {
      "id": 1,
      "name": "Mesin cuci",
      "desc": "Alat untuk mencuci baju",
      "code": "MC",
      "price": 50000,
      "tipe" : {
        "id" : 1,
        "code" : "mt",
        "desc" : "alat cuci"
      }
    },
    {
      "id": 2,
      "name": "Mesin cuci piring",
      "desc": "Alat untuk mencuci piring",
      "code": "MP",
      "price": 70000,
      "tipe" : {
        "id" : 1,
        "code" : "mt",
        "desc" : "alat cuci"
      }
    },
    {
      "id": 3,
      "name": "oven",
      "desc": "Alat untuk mengoven",
      "code": "OV",
      "price": 30000,
      "tipe" : {
        "id" : 2,
        "code" : "cc",
        "desc" : "alat masak"
      }
    },
    {
      "id": 4,
      "name": "kompor",
      "desc": "Alat untuk menggoreng",
      "code": "KP",
      "price": 120000,
      "tipe" : {
        "id" : 2,
        "code" : "cc",
        "desc" : "alat masak"
      }
    }
  ]
}
```

Response
```json
{
  "code": 200,
  "status": "ok",
  "data": "Data berhasil di insert"
}
```

# API SPEC v1.0

## Insert Barang
Request:
- method: POST
- endpoint: `/v1/barang/insert`
- body:

```json
{
  "id": 1,
  "name": "Mesin cuci",
  "desc": "Alat untuk mencuci baju",
  "code": "PL",
  "price": 50000,
  "tipe" : {
    "id" : 2,
    "code" : "mc",
    "desc" : "alat sehari-hari"
  }
}
```

Response:

```json
{
  "code": 200,
  "status": "ok"
}
```

## Delete Barang
Request:
- method: Delete
- endpoint: `/v1/barang/{id}`

Response: 
- Success
```json
{
  "code": 200,
  "status": "ok",
  "data": "1 data terhapus"
}
```
- Fail / tidak ada yang terhapus
```json
{
  "code": 200,
  "status": "ok",
  "data": "Tidak ada data terhapus"
}
```

## Get Barang Semua
Request:
- method: GET
- endpoint: `/v1/barang`

Response:
```json
{
  "code": 200,
  "status": "ok",
  "data": [
    {
      "_id": 5,
      "name": "Mesin cuci",
      "desc": "Alat untuk mencuci baju",
      "code": "PL",
      "price": 50000,
      "tipe": {
        "id": 2,
        "code": "mc",
        "desc": "alat sehari-hari"
      }
    },
    {
      "_id": 1,
      "name": "Mesin cuci",
      "desc": "Alat untuk mencuci baju",
      "code": "PL",
      "price": 50000,
      "tipe": {
        "id": 1,
        "code": "mt",
        "desc": "alat cuci"
      }
    }
  ]
}
```

## Get Barang by Tipe
Request:
- method: GET
- endpoint: `/v1/barang/tipe/{id}`

Response:
```json
{
  "code": 200,
  "status": "ok",
  "data": [
    {
      "_id": 1,
      "name": "Mesin cuci",
      "desc": "Alat untuk mencuci baju",
      "code": "PL",
      "price": 50000,
      "tipe": {
        "id": 1,
        "code": "mt",
        "desc": "alat cuci"
      }
    }
  ]
}
```

## Get Barang by ID
Request:
- method: GET
- endpoint: `/v1/barang/{id}`

Response: 
```json
{
  "code": 200,
  "status": "ok",
  "data": {
    "_id": 1,
    "name": "Mesin cuci",
    "desc": "Alat untuk mencuci baju",
    "code": "PL",
    "price": 50000,
    "tipe": {
      "id": 1,
      "code": "mt",
      "desc": "alat cuci"
    }
  }
}
```

## Get Barang Greater Than Price
Request:
- method: GET
- endpoint: `/v1/barang/greaterThen/{price}`

Response:
```json
{
  "code": 200,
  "status": "ok",
  "data": [
    {
      "_id": 2,
      "name": "Mesin cuci piring",
      "desc": "Alat untuk mencuci piring",
      "code": "MP",
      "price": 70000,
      "tipe": {
        "id": 1,
        "code": "mt",
        "desc": "alat cuci"
      }
    },
    {
      "_id": 4,
      "name": "kompor",
      "desc": "Alat untuk menggoreng",
      "code": "KP",
      "price": 120000,
      "tipe": {
        "id": 2,
        "code": "cc",
        "desc": "alat masak"
      }
    }
  ]
}
```

## Get Barang Less Than Price
Request:
- method: GET
- endpoint: `/v1/barang/lessThen/{price}`

Response:
```json
{
  "code": 200,
  "status": "ok",
  "data": [
    {
      "_id": 3,
      "name": "oven",
      "desc": "Alat untuk mengoven",
      "code": "OV",
      "price": 30000,
      "tipe": {
        "id": 2,
        "code": "cc",
        "desc": "alat masak"
      }
    }
  ]
}
```

## Get barang Greater and Less Then
Request:
- method: POST
- endpoint: `/v1/barang/greaterThenAndLessThen`
- body:

```json
{
  "greaterThan": 20000,
  "lessThen": 50000
}
```

Response:
```json
{
  "code": 200,
  "status": "ok",
  "data": [
    {
      "_id": 3,
      "name": "oven",
      "desc": "Alat untuk mengoven",
      "code": "OV",
      "price": 30000,
      "tipe": {
        "id": 2,
        "code": "cc",
        "desc": "alat masak"
      }
    }
  ]
}
```