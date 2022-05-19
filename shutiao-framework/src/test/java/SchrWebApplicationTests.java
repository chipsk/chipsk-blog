
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;



@RunWith(SpringRunner.class)
@SpringBootTest
class SchrWebApplicationTests {


    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void contextLoads() {
        System.out.println(redisTemplate); //org.springframework.data.redis.core.StringRedisTemplate@4d354a3e
        redisTemplate.opsForValue().set("k1", "v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));
    }

    @Test
    public void insert() {
        OAdvisoryServiceImpl advisoryService = new OAdvisoryServiceImpl();
        OAdvisory advisory = new OAdvisory(1L, 1L, 2L, "hello");
        advisoryService.save(advisory);
    }



}
