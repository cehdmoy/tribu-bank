# tribu-bank 1
<p>
Given this origen data from some "core service"

[
    {
        "accountId": "972288268",
        "product": {
            "productDesc": "CUENTA CORRIENTE",
            "familyId": "CTACTE"
        },
        "balance": {
            "currAmount": {
                "amount": 1995045,
                "currency": "CLP"
            }
        }
    },
    {
        "accountId": "974366843",
        "product": {
            "productDesc": "CUENTA RENTA DIARIA",
            "familyId": "CTAHYS"
        },
        "balance": {
            "currAmount": {
                "amount": 6249308,
                "currency": "CLP"
            }
        }
    }
]

output should look like

[
    {
        "descripcion": "CUENTA CORRIENTE",
        "accountId": "972288268",
        "saldo": "$1.995.045"
    },
    {
        "descripcion": "CUENTA RENTA DIARIA",
        "accountId": "974366843",
        "saldo": "$6.249.308"
    }
]
</p>
