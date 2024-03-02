require('dotenv').config()

const PORT = process.env.PORT

const restaurantsRouter = require('./routes/restaurants')

const express = require('express')
const app = express()
const mongoose = require('mongoose')

mongoose.connect(process.env.DATABASE_URL)
const db = mongoose.connection

db.on('error', (error) => console.error(error))
db.once('open', () => console.log('Connected to the database'))

app.use(express.json())

app.use('/restaurants', restaurantsRouter)

app.listen(PORT, () => {
    console.log('Server started on port ' + PORT)
})