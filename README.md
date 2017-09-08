# LoginStateControl
Login button control


---------------------------------------
*  场景1
 
	登录页面，有若干个动态生成的EditText，需要每个EditText都输入内容按钮才可以点击，否则不可用
*  场景2
	
	登录页面，有若干个EditText,按钮是可以点击，但是如果哪一项未填写，点击按钮就提示哪一项不能为空
	
---------------------------------------

思路：

1）在EditText实例化的时候，绑定`addTextChangedListener`事件，在`afterTextChanged`时把对应的EditText的值放到`map`集合里，再根据map集合的大小或遍历map数据是否为空去控制按钮是否可用。注意`TextWatcher`要写成内部类，并把对应EditText的序号`index`传进去。

2）遇到为空的数据，return就可以了。

