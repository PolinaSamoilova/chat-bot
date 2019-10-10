javac chatBot\*.java
if errorlevel 0 (
    cls
    java chatBot.ChatBot
    del *.class
)
