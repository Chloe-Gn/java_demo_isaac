package eni.demo.demo;

import eni.demo.demo.module4.bll.AlimentManagerV2;
import eni.demo.demo.module4.bll.EniManagerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/*@SpringBootTest
class DemoApplicationTests {


	@Autowired
	AlimentManagerV2 alimentManagerV2;

	@Test
	void contextLoads() {
	}


	@Test
	void TestRG1_200(){

		// vérifier que getAliments fonctionne
		// vérifier que le code métier = 200

		EniManagerResponse response = alimentManagerV2.getAliments();

		Assert.isTrue(response.code.equals("200"),response.message);

	}


	@Test
	void TestRG1_701(){
		EniManagerResponse response = alimentManagerV2.getById(856L);

		Assert.isTrue(response.code.equals("701"),response.message);
	}
}

*/