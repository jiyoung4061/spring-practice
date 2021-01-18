package container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"container.soundsystem"}) // CDPlayerConfig.xml에서 설정한것 대신 java에서는 annotation을 사용함!
public class CDPlayerConfig {
	
}
