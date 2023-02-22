### Setup 
- install Java 19
  use intellij to install openjdk 19 export JAVA_HOME=~/Library/Java/JavaVirtualMachines/openjdk-19.0.2/Contents/Home in .zshrc 
  steps cd ~ -> open .zshrc -> copy paste -> cmd+s
- Make sure you're on Gradle version 7.6 to support building with Java 19. You can check with `gradle --version`.
  If you're not, update by running `sdk install gradle 7.6`.

### API's that are completed 
- /signup
- /login
- /otp


## Task to be done
- Integration with real time SQL database
- Use JWT Tokens for verification