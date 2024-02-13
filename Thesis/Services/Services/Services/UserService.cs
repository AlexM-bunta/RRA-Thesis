using Microsoft.Extensions.Options;
using MongoDB.Driver;
using Services.Configurations;
using Services.Models;

namespace Services.Services;

public class UserService
{
    private readonly IMongoCollection<User> _usersCollection;

    public UserService(IOptions<DatabaseSettings> databaseSettings)
    {
        var mongoClient = new MongoClient(databaseSettings.Value.ConnectionString);
        var mongoDb = mongoClient.GetDatabase(databaseSettings.Value.DatabaseName);

        _usersCollection = mongoDb.GetCollection<User>(databaseSettings.Value.CollectionName);
    }

    public async Task<List<User>> GetAsync() => await _usersCollection.Find(_ => true).ToListAsync();

    public async Task<User> GetAsync(string id) => await _usersCollection.Find(x => x.Id == id).FirstOrDefaultAsync();

    public async Task CreateAsync(User user) => await _usersCollection.InsertOneAsync(user);

    public async Task UpdateAsync(User user) => await _usersCollection.ReplaceOneAsync(x => x.Id == user.Id, user);
}