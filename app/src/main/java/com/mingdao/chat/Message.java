package com.mingdao.chat;

/**
 * Created by gechuanguang on 2017/3/23.
 * 邮箱：1944633835@qq.com
 */

public class Message {


    /**
     * touser : string
     * msg : string
     * type : int
     * file : {"url":"string","id":"string","aid":"string","ft":"string","key":"string","hash":"string","size":"int","name":"string","len":"len","isEmotion":"boolean"}
     * card : {"title":"string","md":"string","text":"string","url":"string","pic":"string","entityid":"string"}
     * refer : {"msgid":"String"}
     */

    private String touser;
    private String msg;
    private int type;
    private FileBean file;
    private CardBean card;
    private ReferBean refer;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FileBean getFile() {
        return file;
    }

    public void setFile(FileBean file) {
        this.file = file;
    }

    public CardBean getCard() {
        return card;
    }

    public void setCard(CardBean card) {
        this.card = card;
    }

    public ReferBean getRefer() {
        return refer;
    }

    public void setRefer(ReferBean refer) {
        this.refer = refer;
    }

    public static class FileBean {
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

    public static class ReferBean {
        /**
         * msgid : String
         */

        private String msgid;

        public String getMsgid() {
            return msgid;
        }

        public void setMsgid(String msgid) {
            this.msgid = msgid;
        }
    }
}
