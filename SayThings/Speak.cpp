

#include <iostream>
using namespace std;

#include "Speaker.h"

JNIEXPORT void JNICALL Java_Speaker_sayHi(JNIEnv *, jobject) {
	cout << "Hello there" << endl;
}

JNIEXPORT void JNICALL Java_Speaker_sayBye(JNIEnv *, jobject) {
	cout << "Bye now" << endl;
}

JNIEXPORT jint JNICALL Java_Speaker_doStuff (JNIEnv * env, jobject me, jint i) {

	jclass classID = env->GetObjectClass(me);
	jmethodID mid = env->GetMethodID(classID, "speakUp","()V");
	env->CallVoidMethod(me, mid);

	cout << "DO STUFF WITH " << i << endl;

	return 22;
}
