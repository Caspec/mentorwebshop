const express = require('express')
const mysql = require('mysql')

const connectionPool = mysql.createPool({
    connectionLimit: 20,
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'mentorwebshop'
})

function getConnectionDB() {
    return connectionPool
}

module.exports = getConnectionDB