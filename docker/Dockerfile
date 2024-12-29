FROM openjdk:17-jdk
WORKDIR /yikit-app
COPY --from=yikit /yikit.base/target/com.alhngzl.yikit.jar yikit-app
ENTRYPOINT ["java", "-jar", "yikit-app"]