using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace Services.Models;

public class User
{
    [BsonId]
    [BsonRepresentation(BsonType.ObjectId)]
    public string? Id { get; set; }

    [BsonElement("Username")] public string Username { get; set; } = string.Empty;

    [BsonElement("Password")] public string Password { get; set; } = string.Empty;

    [BsonElement("Email")] public string Email { get; set; } = string.Empty;
}