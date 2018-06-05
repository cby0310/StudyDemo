import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class HelloTask extends DefaultTask {
    String nickName = 'default'

    @TaskAction
    def action1() { println 'Step 3 I Am ' + name }

    @TaskAction
    def action2() { println 'Step 2 NickName Is ' + nickName }
}

