const express = require('express')
const router = express.Router()
const getConnection = require('./mysqlconnection.js')
const bodyParser = require('body-parser')

router.use(bodyParser.urlencoded({extended: 'false'}));
router.use(bodyParser.json())

// Gets all orders
router.get("/orders", (req, res) => {
    console.log("log --> Get all orders: /orders")
    const queryString = "SELECT * FROM orders"
    getConnection().query(queryString, (err, rows, fields) => {

        if (err) {
            console.log("log --> Failed to query: /orders " + err)
            res.sendStatus(500)
            return
        }

        console.log("log --> SELECT: /orders fetched successfully")
        res.json(rows)
    })
})

module.exports = router