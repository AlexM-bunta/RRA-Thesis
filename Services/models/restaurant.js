const mongoose = require('mongoose')

const restaurantSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    type: {
        type: String,
        required: true
    },
    latitude: {
        type: Number,
        required: true
    },
    longitude: {
        type: Number,
        required: true
    },
    reviewStars: {
        type: Number,
        required: true
    }
})

module.exports = mongoose.model('Restaurants', restaurantSchema)