package com.qa.tests;

import com.qa.base.TestBaseRest;
import com.qa.client.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAPITestBaseRest{

    //TestBaseRest testBaseRest;
    String serviceUrl;
    String apiURL;
    String url;
    RestClient restClient;

    @BeforeMethod
    public void setUP(){
        TestBaseRest testBaseRest=new TestBaseRest();

        serviceUrl=testBaseRest.prop.getProperty("URL");
        apiURL=testBaseRest.prop.getProperty("serviceURL");
        url=serviceUrl+apiURL;
    }

    @Test
    public void getAPITest() throws IOException {
        restClient=new RestClient();
        restClient.get(url);
    }


}
