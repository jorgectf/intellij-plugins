package training.learn.lesson.swift.refactorings

import com.intellij.icons.AllIcons
import training.learn.LessonsBundle
import training.learn.interfaces.Module
import training.learn.lesson.kimpl.KLesson
import training.learn.lesson.kimpl.LessonContext
import training.learn.lesson.kimpl.LessonSample
import training.learn.lesson.kimpl.parseLessonSample

class SwiftChangeSignatureLesson(module: Module) : KLesson("swift.refactorings.change.signature", LessonsBundle.message("swift.refactoring.change.signature.name"), module, "Swift") {

  private val sample: LessonSample = parseLessonSample("""
import UIKit

class ChangeSignature: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        let x = 0
        let y = 50

        let tableView = UITableView()
        method(tableView: tableView, x: x, y: y)
        self.view.addSubview(tableView)
    }

    private func method(tableView: UITableView, x: Int, y: Int) {
        let header = UILabel()
        header.text = "AppCode"
        header.sizeToFit()

        tableView.frame = CGRect(x: x, y: y, width: 320, height: 400)
        tableView.tableHeaderView = header
    }
}""".trimIndent())
  override val lessonContent: LessonContext.() -> Unit = {
    prepareSample(sample)

    task { caret(16, 22) }
    task {
      text(LessonsBundle.message("swift.refactoring.change.signature.intro"))
    }
    task {
      triggers("ChangeSignature")
      text(LessonsBundle.message("swift.refactoring.change.signature.exec", action("ChangeSignature"), code("method"), code("setup")))
    }
    task {
      triggers("ChangeSignature")
      text(LessonsBundle.message("swift.refactoring.change.signature.exec.again", action("ChangeSignature"), code("tableView"), code("table")))
    }
    task {
      triggers("ChangeSignature")
      text(LessonsBundle.message("swift.refactoring.change.signature.final", icon(AllIcons.General.ArrowUp), icon(AllIcons.General.ArrowDown)))
    }
  }
}