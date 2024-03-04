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

router.get('/getTypes', async (req, res) => {
    try {
        var types = []

        const list = await Restaurant.find()

        list.forEach((x) => {
            const type = x.get('Type')
            if (!types.includes(type)) {
                types.push(type)
            }
        })

        res.json(types)

    } catch (err) {
        res.status(500).send({ message: err.message })
    }
})

router.get('/get/:type', async (req, res) => {
    try {
        const list = await Restaurant.find()

        const filteredList = list.filter(x => x.get('Type') === req.params.type)

        res.json(filteredList)

    } catch (err) {
        res.status(500).send({ message: err.message })
    }
})



module.exports = router