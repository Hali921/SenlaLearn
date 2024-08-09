package config;



public class JavaConfiguration implements Configuration{
    @Override
    public String getPackageToScan() {
        return "homework-3/homework-3-ioc/main";
    }

}
