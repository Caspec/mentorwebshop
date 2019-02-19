const express = require('express')
const router = express.Router()
const getConnection = require('./mysqlconnection.js')
const bodyParser = require('body-parser')

router.use(bodyParser.urlencoded({ extended: 'false' }));
router.use(bodyParser.json())

// Gets all products
router.get("/products", (req, res) => {
    console.log("log --> Get all products: /products")
    const queryString = "SELECT product.*, image.*, category.* FROM product INNER JOIN image ON product.product_id = image.fk_product_image_id INNER JOIN category ON product.fk_category_id = category.category_id;"
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

// Gets one product by ID
router.get("/product/:id", (req, res) => {
    console.log("log --> Fetching product id: " + req.params.id)
    const productId = req.params.id
    const queryString = "SELECT * FROM product WHERE product_id = ?"
    getConnection().query(queryString, [productId], (err, rows, fields) => {

        if (err) {
            console.log("log --> Failed to query: /product/:id " + err)
            res.sendStatus(500)
            return
        }
        console.log("log --> SELECT: /product/:id fetched successfully")
        res.json(rows)
    })
})

module.exports = router