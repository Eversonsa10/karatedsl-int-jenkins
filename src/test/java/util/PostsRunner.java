package util;

import com.intuit.karate.junit5.Karate;

public class PostsRunner {
    @Karate.Test
    public Karate testPosts(){
        return Karate.run("classpath:posts/post.feature").relativeTo(getClass());
    }
}
