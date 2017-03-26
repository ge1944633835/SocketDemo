package com.mingdao.chat.Moudle;

/**
 * Created by gechuanguang on 2017/3/25.
 * 邮箱：1944633835@qq.com
 */

public class ReceiveMessage {


    /**
     * id : string
     * from : string
     * uname : string
     * logo : string
     * to : string
     * type : int
     * msg : {"con":"string","files":{"url":"string","id":"string","aid":"string","ft":"string","key":"string","hash":"string","size":"int","name":"string","len":"len","isEmotion":"boolean"}}
     * card : {"title":"string","md":"string","text":"string","url":"string","pic":"string","entityid":"string"}
     * app : {"appid":"","name":"","url":""}
     * refer : {"msgid":"string","msg":"string","time":"Date","user":{"id":"string","name":"string","avatar":"string"}}
     * time : string
     */

    private String id;
    private String from;
    private String uname;
    private String logo;
    private String to;
    private String type;
    private MsgBean msg;
    private CardBean card;
    private AppBean app;
    private ReferBean refer;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public CardBean getCard() {
        return card;
    }

    public void setCard(CardBean card) {
        this.card = card;
    }

    public AppBean getApp() {
        return app;
    }

    public void setApp(AppBean app) {
        this.app = app;
    }

    public ReferBean getRefer() {
        return refer;
    }

    public void setRefer(ReferBean refer) {
        this.refer = refer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static class MsgBean {
        /**
         * con : string
         * files : {"url":"string","id":"string","aid":"string","ft":"string","key":"string","hash":"string","size":"int","name":"string","len":"len","isEmotion":"boolean"}
         */

        private String con;
        private FilesBean files;

        public String getCon() {
            return con;
        }

        public void setCon(String con) {
            this.con = con;
        }

        public FilesBean getFiles() {
            return files;
        }

        public void setFiles(FilesBean files) {
            this.files = files;
        }

        public static class FilesBean {
            /**
             * url : string
             * id : string
             * aid : string
             * ft : string
             * key : string
             * hash : string
             * size : int
             * name : string
             * len : len
             * isEmotion : boolean
             */

            private String url;
            private String id;
            private String aid;
            private String ft;
            private String key;
            private String hash;
            private String size;
            private String name;
            private String len;
            private String isEmotion;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getFt() {
                return ft;
            }

            public void setFt(String ft) {
                this.ft = ft;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLen() {
                return len;
            }

            public void setLen(String len) {
                this.len = len;
            }

            public String getIsEmotion() {
                return isEmotion;
            }

            public void setIsEmotion(String isEmotion) {
                this.isEmotion = isEmotion;
            }
        }
    }

    public static class CardBean {
        /**
         * title : string
         * md : string
         * text : string
         * url : string
         * pic : string
         * entityid : string
         */

        private String title;
        private String md;
        private String text;
        private String url;
        private String pic;
        private String entityid;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMd() {
            return md;
        }

        public void setMd(String md) {
            this.md = md;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getEntityid() {
            return entityid;
        }

        public void setEntityid(String entityid) {
            this.entityid = entityid;
        }
    }

    public static class AppBean {
        /**
         * appid :
         * name :
         * url :
         */

        private String appid;
        private String name;
        private String url;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ReferBean {
        /**
         * msgid : string
         * msg : string
         * time : Date
         * user : {"id":"string","name":"string","avatar":"string"}
         */

        private String msgid;
        private String msg;
        private String time;
        private UserBean user;

        public String getMsgid() {
            return msgid;
        }

        public void setMsgid(String msgid) {
            this.msgid = msgid;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : string
             * name : string
             * avatar : string
             */

            private String id;
            private String name;
            private String avatar;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
