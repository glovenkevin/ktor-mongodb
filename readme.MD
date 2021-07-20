# Ktor with MongoDB

This is my project for learning mongoDB using ktor application
and docker as deployment. 

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
  "price": 50000
}
```

Response:

```json
{
  "code": 200,
  "status": "success"
}
```