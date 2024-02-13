using Microsoft.AspNetCore.Mvc;
using Services.Models;
using Services.Services;

namespace Services.Controllers;

[ApiController]
[Route("api/[controller]/[action]")]
public class UserController : ControllerBase
{
    private readonly UserService _userService;

    public UserController(UserService userService)
    {
        _userService = userService;
    }

    [HttpGet]
    public async Task<IActionResult> Get()
    {
        var users = await _userService.GetAsync();
        

        if (users.Equals(null))
            return BadRequest("No users found.");

        return Ok(users);
    }
    
    [HttpGet("{id}")]
    public async Task<IActionResult> Get(string id)
    {
        var user = await _userService.GetAsync(id);

        if (user.Equals(null))
            return NotFound("No users found.");

        return Ok(user);
    }
    
    [HttpPost]
    public async Task<IActionResult> Create([FromBody] User user)
    {
        try
        {
            await _userService.CreateAsync(user);
            return Ok();
        }
        catch (Exception ex)
        {
            return StatusCode(StatusCodes.Status502BadGateway);
        }
    }
    
    [HttpPut]
    public async Task<IActionResult> Update([FromBody] User user)
    {
        try
        {
            await _userService.UpdateAsync(user);
            return Ok();
        }
        catch (Exception ex)
        {
            return StatusCode(StatusCodes.Status502BadGateway);
        }
    }
}