package com.smartlink.smartlinkapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
//    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

//    private val _messageStatus = MutableStateFlow<MessageStatus>(MessageStatus.Idle)
//    val messageStatus: StateFlow<MessageStatus> get() = _messageStatus
//
//    fun onSendMessageButtonClick(chatId: String, message: Message) {
//        viewModelScope.launch {
//            _messageStatus.value = MessageStatus.Loading
//            try {
//                sendMessageUseCase.execute(chatId, message)
//                _messageStatus.value = MessageStatus.Success
//            } catch (e: Exception) {
//                _messageStatus.value = MessageStatus.Error(e.localizedMessage)
//            }
//        }
//    }
}
