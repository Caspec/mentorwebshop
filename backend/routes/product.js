const express = require('express')
const router = express.Router()
const getConnection = require('./mysqlconnection.js')
const bodyParser = require('body-parser')

router.use(bodyParser.urlencoded({extended: 'false'}));
router.use(bodyParser.json())

// Gets all products
router.get("/products", (req, res) => {
    console.log("log --> Get all products: /products")
    const queryString = "SELECT * FROM product"
    getConnection().query(queryString, (err, rows, fields) => {

        if (err) {
            console.log("log --> Failed to query: /products " + err)
            res.sendStatus(500)
            return
        }

        console.log("log --> SELECT: /products fetched successfully")
        res.json(rows)
    })
})

module.exports = router