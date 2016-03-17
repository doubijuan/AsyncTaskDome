# AsyncTaskDome
AsyncTask是Android为了简化异步操作而封装的异步任务操作抽象类。当我们需要在程序中执行耗时的异步操作时，我们可以考虑使用AsyncTask来实现。

AsyncTask的使用比较简单，由于AsyncTask是一个抽象类，我们需要写一个类来继承AsyncTask,继承AsyncTask需要指定三个泛型参数，参数分别表示为： 
（1）Params:在执行AsyncTask时需要传入的参数，比如我们输入的String类型URL 
（2）Progress:后台任务执行中返回的进度值类型，如果需要在界面上显示当前进度，则就用Progress指定的泛型作为进度单位。 
（3）Result:耗时操作完成后返回的结果，如果需要对结果进行返回，那么就用这里指定的泛型作为返回的类型。

实现AsyncTask类还需要重写相应的回调方法，一般我们用到的有如下四个方法，他们都是自动被调用的，记得不要手动的调用： 
（1）doInBackground(Void… params):必须重写，异步执行耗时操作 
（2）onPreExecute()：执行耗时操作前被调用，通常用来完成一些初始化操作 
（3）onProgressUpdate(Void… values)：将doInBackground方法返回的值传递给该方法，在doInBackground中调用publishProgroess()方法可以且来更新进度 
（4）onPostExecute(Void result)：耗时的异步任务完成后回调该方法

需要说明一点:这几个方法中，只有doInBackground方法是在子线程中执行的，其他的方法都是在主线程中执行的。

启动和取消这个异步任务的方法分别是： 
（1）myAsyncTask.execute() 其中该任务 
（2）myAsyncTask.cancel() 取消该任务

我们已经大概了解了AsyncTask的基础知识，接下来就以如下三个点做一些实例，加深一下印象。
![图片说明](http://img.blog.csdn.net/20160305003908393)
