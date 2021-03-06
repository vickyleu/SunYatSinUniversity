package com.superfactory.sunyatsen.Communication

import com.superfactory.sunyatsen.Bean.*
import com.superfactory.sunyatsen.Bean.BaseBean.NoteStoreBean
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Created by vicky on 2018.01.23.
 *
 * @Author vicky
 * @Date 2018年01月23日  18:28:13
 * @ClassName 这里输入你的类名(或用途)
 */
interface RetrofitImpl {

    @GET("{path}")
    fun eraseBadge(@Path("path") path: String): Observable<ResponseBody>


    @POST("login?__ajax")
    fun login(@Query("username") username: String, @Query("password") password: String,
              @Query("mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("sys/user/infoData;JSESSIONID={JSESSIONID}?")
    fun loginAfter(@Path("JSESSIONID") JSESSIONID: String,
                   @Query("__ajax=true&mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("sys/user/savePwd;JSESSIONID={JSESSIONID}?")
    fun changePsw(@Path("JSESSIONID") JSESSIONID: String,
                  @Body changeBean: ChangePswStruct,
                  @Query("__ajax=true&mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("api/naire/data;JSESSIONID={JSESSIONID}?")
    fun questionnaireList(@Path("JSESSIONID") JSESSIONID: String,
                          @Query("__ajax=true&mobileLogin") mobileLogin: Boolean, @Body abc: Holder? = Holder()): Observable<ResponseBody>

    @POST("api/naire/findQuestionByParentId;JSESSIONID={JSESSIONID}?")
    fun questionnaireDetail(@Path("JSESSIONID") JSESSIONID: String, @Body bean: QuestionnaireQueryBean,
                            @Query("__ajax=true&mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("api/naire/save;JSESSIONID={JSESSIONID}?")
    fun storeQuestionnaire(@Path("JSESSIONID") JSESSIONID: String, @Body bean: QuestionnaireCommitBean,
                           @Query("__ajax=true&mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("api/workinglog/data;JSESSIONID={JSESSIONID}?")
    fun queryNoteList(@Path("JSESSIONID") JSESSIONID: String,
                      @Query("__ajax=true&mobileLogin") mobileLogin: Boolean, @Body bean: NoteListBean): Observable<ResponseBody>

    @POST("api/pushrecord/data;JSESSIONID={JSESSIONID}?")
    fun loadMsg(@Path("JSESSIONID") JSESSIONID: String,
                @Query("__ajax=true&mobileLogin") mobileLogin: Boolean, @Body msgBean: MsgBean): Observable<ResponseBody>

    @POST("api/pushrecord/deleteAll;JSESSIONID={JSESSIONID}?")
    fun eraseMsg(@Path("JSESSIONID") JSESSIONID: String,
                 @Query("__ajax=true&mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("api/workinglog/findDutyList;JSESSIONID={JSESSIONID}?")
    fun dutyList(@Path("JSESSIONID") JSESSIONID: String,
                 @Query("__ajax=true&mobileLogin") mobileLogin: Boolean): Observable<ResponseBody>

    @POST("api/workinglog/findBzMatterInfo;JSESSIONID={JSESSIONID}?")
    fun mattersList(@Path("JSESSIONID") JSESSIONID: String,
                    @Query("__ajax=true&mobileLogin") mobileLogin: Boolean, @Body bean: MattersBean): Observable<ResponseBody>

    @POST("api/workinglog/save;JSESSIONID={JSESSIONID}?")
    fun storeNote(@Path("JSESSIONID") JSESSIONID: String,
                  @Query("__ajax=true&mobileLogin") mobileLogin: Boolean, @Body bean: NoteStoreBean): Observable<ResponseBody>

    @Multipart
    @POST("sys/user/imageUpload;JSESSIONID={JSESSIONID}?__ajax=true")
    fun uploadPicture(@Path("JSESSIONID") JSESSIONID: String,@Part parts: List<MultipartBody.Part>): Observable<ResponseBody>

    @POST("sys/user/infoEdit;JSESSIONID={JSESSIONID}?__ajax=true")
    fun storeProfile(@Path("JSESSIONID") JSESSIONID: String,
                       @Query("__ajax=true&mobileLogin") mobileLogin: Boolean, @Body bean: ProfileStoreBean):Observable<ResponseBody>
}