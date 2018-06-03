package ru.endlesscode.miet.orioks.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


fun EditText.asObservable(): Observable<CharSequence> {
    return PublishSubject.create {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                it.onNext(s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ignored
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ignored
            }
        })
    }
}
