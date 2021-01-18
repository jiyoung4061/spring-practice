package container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author javafullstack-bitacademy
 * 
 * Explicit Configuration : Java Configuration
 *     JavaConfig3	   <------------   JavaConfig1	+	JavaConfig2
 * (VideoPlayerConfig)	   [Import]	   (DVDConfig)	  (DVDPlayerConfig)
 *
 * JavaConfig3 = javaConfig2 + JavaConfig1 
 * 
 */

@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {
	
}
