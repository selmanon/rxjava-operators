import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject


class BehaviorSubjectTest {
    private var behaviorSubjectValue: BehaviorSubject<String> = BehaviorSubject.createDefault("")


    fun setValue(value: String) {
        behaviorSubjectValue.onNext(value)
    }

    fun valueObservable() : BehaviorSubject<String>{
         return behaviorSubjectValue
    }
}

class PublishSubjectTest {
    private var publishSubjectValue: PublishSubject<String> = PublishSubject.create()


    fun setValue(value: String) {
        publishSubjectValue.onNext(value)
    }

    fun valueObservable() : PublishSubject<String>{
        return publishSubjectValue
    }
}

fun main() {
    System.out.println("BehaviorSubject")
    // BehaviorSubject
    val behaviorSubjectTestInstance = BehaviorSubjectTest()

    val behavoirSubjectValue : BehaviorSubject<String> = behaviorSubjectTestInstance.valueObservable()

    behaviorSubjectTestInstance.setValue("Some type 1")
    behaviorSubjectTestInstance.setValue("Some type 2")

    behavoirSubjectValue.subscribe(System.out::println)

    System.out.println("PublishSubject")
    // PublishSubject
    val publishSubjectTestInstance = PublishSubjectTest()

    val publishSubjectValue : PublishSubject<String> = publishSubjectTestInstance.valueObservable()

    publishSubjectTestInstance.setValue("Some type 1")
    publishSubjectTestInstance.setValue("Some type 2")

    publishSubjectValue.subscribe(System.out::println)

    publishSubjectTestInstance.setValue("Some type 3")


}