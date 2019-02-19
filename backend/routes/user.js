const express = require('express')
const router = express.Router()
const getConnection = require('./mysqlconnection.js')
const bodyParser = require('body-parser')

router.use(bodyParser.urlencoded({extended: 'false'}));
router.use(bodyParser.json())

// Gets one user by ID
router.get("/user/:id", (req, res) => {

    console.log("log --> Fetching user id: " + req.params.id)

    const userId = req.params.id
    const queryString = "SELECT * FROM user WHERE user_id = ?"
    getConnection().query(queryString, [userId], (err, rows, fields) => {

        if (err) {
            console.log("log --> Failed to query: /user/:id " + err)
            res.sendStatus(500)
            return
        }

        console.log("log --> SELECT: /user/:id fetched successfully")
        res.json(rows)
    })
})

// Gets all users
router.get("/users", (req, res) => {
    console.log("log --> Get all users: /users")
    const queryString = "SELECT * FROM user"
    getConnection().query(queryString, (err, rows, fields) => {

        if (err) {
            console.log("log --> Failed to query: /users " + err)
            res.sendStatus(500)
            return
        }

        console.log("log --> SELECT: /users fetched successfully")
        res.json(rows)
    })
})

// Post new user
router.post("/create_user", (req, res) => {
    const username = req.body.user_name.toString();
    const password = req.body.user_password.toString();
    const queryString = "INSERT INTO `user` (user_name, user_password) VALUES (?, ?);"
    getConnection().query(queryString, [username, password], (err, results) => {
        if (err) {
            console.log("log --> Failed to query: /user_create " + err)
            res.sendStatus(500)
            return
        }
        console.log("log --> create new user: /user_create created successfully")
        res.end()
    })
})


module.exports = router