const express = require('express')
const Restaurant = require('../models/restaurant')
const router = express.Router()

router.get('/getAll', async (req, res) => {
    try {
        const restaurants = await Restaurant.find()
        res.json(restaurants)
    } catch (err) {
        res.status(500).send({ message: err.message })
    }
})


module.exports = router