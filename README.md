# **Socket Communication**

## Connect

连接信息:
urlqueryString 中加上 token=你的token&app=你的appKey

注: 要加的地方有两个, 都要加上, 本地有可能不加就能连接成功, 但线上, 肯定会失败!!!!!!


## To Server

#### Result 通用参数一, 表示成功与否

###### Param 1  (Success)
```javascript
    false
```
###### Param 1  (Error)
```javascript
{
    error:"Error Message"
}
```


### “current chat” 设置当前聊天用户

##### json

```javascript
{
    id: '用户AccountID或群组ID'
}

```

##### Param 2  (Result)

```javascript
1 成功 0 失败
```


### "operate" 会话操作 (Web Only)

```javascript
{
    ... : ...
}
```

### "unread count"  获取Chat未读计数

```javascript
{
}
```

##### Param 2  (Result)

```javascript
{
    user:[
        {
            id: "",
            num: int
        }
    ],
    group:[
        {
            id: "",
            num: int,
            ispush: boolean,
            at: false,
            msgid: 123123123, // at消息id,当为at消息时有此字段
            time: timeStamp   // at消息时间戳当为at消息时有此字段
        }
    ],
    num: int, // 未读总计数
    notPush: int // 不通知的计数
}
```

#### "all unread"  获取所有未读计数,包含Inbox计数,(Web Only)

```javascript
{
}

```

##### Param 2 (Result)

```javascript
{
    count: int,
    notPush: int
}
```


#### "clear unread"  消除Chat计数

```javascript
{
    type: string, // 1 : 用户, 2. 群组
    id: string  // 用户AccountId 或者 群组Id
}
```

##### Param 2 (Result)

```javascript
 1
```





#### "clear all unread" 清楚所有计数
```javascript
{
}
```
##### Param 2 (Result)
```javascript
 1
```

#### "inbox unread" Inbox未读计数消息 (Web Only)
```javascript
{
}
```
##### Param 2 (Result)
```javascript
[
    {
         type:int, //inboxType,
         value:string,// post,system,task,calendar,knowledge
         time: string,
         msg: {
            con: string
         },
         count: int // 未读计数
    }
]
```

#### "send message" 发送消息

```javascript
{
    touser: string, //接收者 AccountId
    msg:  string,  //消息文本
    type:int,  // 1 文本 2 图片 3 语音 4 附件 5 卡片
    file:{     // 可选
        url: string,
        id: string, // FileID
        aid: string, //
        ft: string,
        key: string,
        hash: string,
        size: int,
        name: string,
        len: len,
        isEmotion: boolean // true or false
    },
    card:{
        title: string, // 呈现一级文本(必须);
        md: string, //"task","calendar","post","vote","" 明道内置应用 时存在该字段(必须),否则不存在
        text: string, // 呈现二级文本
        url: string, // 跳转链接(必须)全路径
        pic: string, // 明道应用时, 该字段不存在, 非明道应用,为应用自定义图片
        entityid: string  // 实体id, 如taskid, calendarid,postid 或其他应用内实体id
    },
    refer:{
        msgid: String
    }
}
```

##### Param 1 (Result)

```javascript
    //成功时
    {
        id: string // messageid
    }
    //失败时
    {
        error: 'message'
    }

    /*
        "not my contract"  //不是我的联系人(包括同事和好友)
        "database error"   //数据库错误
        "from user not found" // 当前用户没找到
     */
```

#### "send group message" 发送群组消息

```javascript
{
    togroup: string, //接收者 AccountId
    msg: string, //消息文本
    type: int,  // 1 文本 2 图片 3 语音 4 附件 5 卡片
    file: {     // 可选
        url: string,
        id: string, // FileID
        aid: string, //
        ft: string,
        key: string,
        hash: string,
        size: int,
        name: string,
        len: len,
        isEmotion: boolean // true or false
    },
    card: {
        title: string, // 呈现一级文本(必须);
        md: string, //"task","calendar","post","vote","" 明道内置应用 时存在该字段(必须),否则不存在
        text: string, // 呈现二级文本
        url: string, // 跳转链接(必须)全路径
        pic: string, // 明道应用时, 该字段不存在, 非明道应用,为应用自定义图片
        entityid: string  // 实体id, 如taskid, calendarid,postid 或其他应用内实体id
    },
    refer:{
      msgid: String
    }
}
```

##### Param 1 (Result)

```javascript
{
   //成功时
    {
        id: string // messageid
    }
    //失败时
    {
        error: 'message'
    }
}

    /*
        "not in group"  //不在该群组中
        "group not found"   //群组没找到
        "from user not found" // 当前用户没找到
        "database err" //数据库错误
     */

```

#### "upload token"  获取七牛上传token

```javascriptjson
{
    type : int // 1 图片 2 附件 3 语音
}
```

##### Param 2 (Result)

```javascript
{
    token: string , // token
    key: string  // 规则是  accountid/year(2016)/month(6)/day(14)
}
```

#### "remove session" 移除session会话

```javascript
{
    type: int, // 1 用户, 2 群组 , 3-99 Inbox应用消息 3:系统消息 4 动态消息 5 日程消息 6 任务消息 7知识消息  100 公众号
    id: string     // 用户AccountId 或 群组Id
}
```

##### Param 2 (Result)

```javascript
    1
```

#### "shake shake" 人对人,抖屏

```javascript
{
    aid: string,
    messageId: string
}
```

##### Param 2 (Result)

```javascript
    1
```


#### "group shake" 群组抖人,@

```javascript
{
    toUser: array, //被at的用户AccountId []
    gid: string, // groupid
    messageId: string
}
```

##### Param 2 (Result)

```javascript
    1
```


#### "clear notification" 消除Inbox计数,并通知其他客户端即时消除呈现的计数

```javascript
{
    type: "类型字符串"   //system post calendar task knowledge
    value: 0,           //剩余未读计数
    clear: boolean      //是否执行清除操作, 移动端传false
}
```


#### "voice as read" 标记语音消息为已读
```json
{
    messageId: string
}
```


* * *

## From Server

#### "operate"  会话操作同步 (Web Only)

```javascript
{
}
```

#### "shake shake" 用户抖屏

```javascript
{
    aid: string // 发送者AccountId
}
```

#### "group shake" 群组抖屏

```javascript
{
    from: string, // 发送抖屏这AccountId
    gid: string // 群组Id
}
```


#### "new message" 收到用户消息

```javascript
{
    id: string, // 消息id
    from: string, // 发送者AccountId
    uname: string, // 发送者姓名
    logo: string, // 发送者头像url
    to: string, //接收者AccountId
    type: int, // 消息类型  1 文本 2 图片 3 语音 4 附件 5 卡片
    msg: {
        con: string, //消息文本内容
        files:{     // 可选
            url: string,
            id: string, // FileID
            aid: string, //
            ft: string,
            key: string,
            hash: string,
            size: int,
            name: string,
            len: len,
            isEmotion: boolean // true or false
        }
    },
    card:{
        title: string, // 呈现一级文本(必须);
        md: string, //"task","calendar","post","vote","kcfile","kcfolder","" 明道内置应用 时存在该字段(必须),否则不存在
        text: string, // 呈现二级文本
        url: string, // 跳转链接(必须)全路径
        pic: string, // 明道应用时, 该字段不存在, 非明道应用,为应用自定义图片
        entityid: string  // 实体id, 如taskid, calendarid,postid 或其他应用内实体id
    },
    app: {
        appid: "",
        name: "",
        url: ""
    },
    refer: {
      msgid:string, // 消息Id
      msg:string,   // 消息文本
      time: Date,    //消息时间
      user: {
        id: string,
        name: string,
        avatar: string
      }
    },
    time: string // date 类型
}
```


#### "new group message" 收到群组消息

```javascript
{
    id: string, // 消息id
    from: string, // 发送者AccountId
    uname: string, // 发送者姓名
    logo: string, // 发送者头像url
    to: string, //groupId
    groupname: string, // 群组名称
    avatar: string, //群组头像
    type: int, // 消息类型  1 文本 2 图片 3 语音 4 附件 5 卡片
    sysType: int, // 系统消息类型, 1. 加人 2. 减人  3. 重命名群组  4.其他
    isPush:boolean //是否接受消息推送
    msg: {
        con: string, //消息文本内容
        files:{     // 可选
            url: string,
            id: string, // FileID
            aid: string, //
            ft: string,
            key: string,
            hash: string,
            size: int,
            name: string,
            len: len,
            isEmotion: boolean // true or false
        }
    },
    card:{
        title: string, // 呈现一级文本(必须);
        md: string, //"task","calendar","post","vote","kcfile","" 明道内置应用 时存在该字段(必须),否则不存在
        text: string, // 呈现二级文本
        url: string, // 跳转链接(必须)全路径
        pic: string, // 明道应用时, 该字段不存在, 非明道应用,为应用自定义图片
        entityid: string  // 实体id, 如taskid, calendarid,postid 或其他应用内实体id
    },
    app: {
        appid: "",
        name: "",
        url: ""
    },
    refer: {
          msgid : string, // 消息Id
          msg : string,   // 消息文本
          time: Date,    //消息时间
          user: {
              id: string,
              name: string,
              avatar: string
          }
    },
    time: string // date 类型
}
```

#### "new group" 被加入群组

```javascript
{
    id: string,   //groupid
    name: string, //群组名称
    logo: string,//群组头像
    uCount: int, //群组成员数
    admins: [],//群组管理员
    isPost: boolean, //是否为动态群
    cuser: string, // 群组创建者
    isPush: true
}
```

#### "group member added" 有人加入群组

```javascript
{
    id: string,   //groupid
    name: string, //群组名称
    users: [      //被加入的用户
        {
            AccountID:string,
            Email:string,
            Fullname:string,
            Avatar:string
        }
        ...
    ]
}
```

#### "group renamed" 群组被重命名

```javascript
{
    oldName: string, //原群组名称
    name: string,//新群组名称
    gid: string, //groupid
    user: {
        id: string,   //操作者AccountId
        logo: string  //操作者头像
    }
}
```

#### "removed from group" 被某群组移除

```javascript
{
    id: string,//群组Id
    name: string //群组名称
}

```

#### "group member removed" 群组成员被移除

```javascript
{
    id: string, //群组id
    name: string//群组名称
    aid: string //被移除用户AccountId
}
```

#### "group admin removed" 群组管理员被移除

```javascript
{
    removedAid: string,//被移除管理员的用户AccountId
    aid: string,//操作者AccountId
    gid: string //群组Id
}
```

#### "group admin added" 群组管理员添加

```javascript
{
    addAid: string, // 被添加为管理员
    gid: string // 群组ID
}

```

#### "set group notice" 设置了群组通知

```javascript
{
    gid: string, //groupid
    aid: string, //操作者id
    isPush: boolean//是否push
}
```

#### "clear all unread" 清除所有计数,chat+inbox消息计数

```javascript
{
}
```

#### "clear unread" 清除计数

```javascript
{
    type: int,    // 1 用户 2 群组
    id: string    //type=1:用户Accountid  type=2:群组id
}
```

#### "clear notification" 清除Inbox消息

```javascript
    {
        time: int,     // 消息发送Unix时间戳
        type : string,  // system post calendar task knowledge
        value: int    //消除后的计数
    }
```

#### "session removed" 会话移除

```javascript
{
    id: sessionID //type为1时 id=用户Accountid,type为2时, id =群组id,
    type: int,    // 1 用户 2 群组 3 系统消息 4 动态消息 5 日程消息 6 任务消息 7 知识消息  ....  100 公众号
}
```

#### "new notify" 新inbox消息

```javascript
{
    aid: string, //用户AccountId
    type: string,   //mentioned comment systemmessage calendarmessage taskmessage taskcomment taskmention taskreply folderreply foldermention foldercomment addressbookmessage kcemessage
    dtype: int   //0 动态消息, 1 系统消息, 2 日程消息 3 任务消息, 4 知识消息
}

```


#### "new history" 新history消息, 聊天列表项

```javascript
{
    from: {
        accountId: string, // 发送者id
        fullname: string, // 发送者名称
        avatar: string //头像路径
    },
    to: {
        //如果是群
        gid: string // 群组id
        //如果是用户
        aid: string // 用户id
    },
    message:string //消息文本
}

```

#### "new session" 新session, 聊天列表

```javascript
{
    //发送者
    from:{
        accountId: '', // 发送者id
        fullname: '', // 发送者名称
        avatar: ''   //头像路径
    },
    type: 1, // 1 用户, 2 群组(群聊)
    message: '',
    id: 'sessionid', // 用户accountid 或 群组id
    name: '呈现的用户名或群组名称',
    logo: '呈现的用户头像或群组头像'
}

```



#### "ban speak" 群组禁言

```javascript
    {
        groupid:"群组id",
        operator:{
            accountId:"",
            fullName:"",
            avatar:""
        }
    }
```

#### "permit speak" 解除群组禁言

```javascript
    {
        groupid:"群组id",
        operator:{
            accountId:"",
            fullName:"",
            avatar:""
        }
    }
```

#### "voice as read" 标记语音消息为已读

```javascript
    {
        messageId:"messageId"
    }

````



注: 在发送用户消息和群组消息时,send message 和send group message 时
如果返回结果 为 {error:'removeit'}
则说明该用户与我既不是好友也不是同事 或者 我已不在该群中

