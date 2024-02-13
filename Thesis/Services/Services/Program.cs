using Services.Configurations;
using Services.Services;

var builder = WebApplication.CreateBuilder(args);
var services = builder.Services;

services.Configure<DatabaseSettings>(builder.Configuration.GetSection("MongoDatabase"));

services.AddControllers();
services.AddEndpointsApiExplorer();
services.AddSwaggerGen();

services.AddScoped<UserService>();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.MapControllers();

app.Run();
