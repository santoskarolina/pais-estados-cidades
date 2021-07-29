
# Lista de todos os países + estados do Brasil + cidades do Brasil

#### Get todos os países

#### { url = https://pais-estados-cidades.herokuapp.com}  

```http
  GET url/api/v1/paises

[
    {
    "id": 1,
    "nome": "Brazil",
    "nomePt": "Brasil",
    "sigla": "BR",
    "bacen": 1058
  },
  {
    "id": 2,
    "nome": "Afghanistan",
    "nomePt": "Afeganistão",
    "sigla": "AF",
    "bacen": 132
  },
]  
```
#### Get país por id
```http
  GET url/api/v1/paises/{id}

{
  "id": 1,
  "nome": "Brazil",
  "nomePt": "Brasil",
  "sigla": "BR",
  "bacen": 1058,
  "totalEstados": 27
}
```

#### Get estados de um país
```http
  GET url/api/v1/paises/1/estados

[
  {
    "id": 1,
    "nome": "Acre",
    "uf": "AC",
    "ibge": 12,
    "totalCidades": 0
  },
  {
    "id": 2,
    "nome": "Alagoas",
    "uf": "AL",
    "ibge": 27,
    "totalCidades": 0
  }
]  
```

#### Get cidades de um Estado
```http
  GET url/api/v1/estados/10/cidades

[
 {
    "id": 9,
    "nome": "AÇAILÂNDIA",
    "ibge": 2100055
  },
  {
    "id": 8,
    "nome": "BACABAL",
    "ibge": 2101202
  }
]  
```

#### POST novo país
```http
  POST url/api/v1/paises
  {
    "nome": "United States of America",
    "nomePt": "Estados Unidos",
    "sigla": "USA",
    "bacen": 2496
  }
```

#### POST novo Estado
```http
  POST /api/v1/estados
  {
      "nome": "California",
      "uf": "CA",
      "ibge": 10,
      "pais": 41
  }
```
#### POST nova Cidade
```http
  POST url/api/v1/cidades
  {
    "nome": "barra do corda",
    "ibge": 10,
    "estado": 10
  }
```
