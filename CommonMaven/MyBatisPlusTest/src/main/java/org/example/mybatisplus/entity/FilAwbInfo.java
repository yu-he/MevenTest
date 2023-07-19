package org.example.mybatisplus.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FilAwbInfo {
    /**
     * 运单完整编码
     */
    private String billId;
    /**
     * 运单类型
     */
    private String stockTypeId;
    /**
     * 运单前缀
     */
    private String stockPre;
    /**
     * 运单号
     */
    private String stockNo;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * carrierProductId
     */
    private String carrierProductId;
    /**
     * 换单前单号
     */
    private String previousBillId;
    /**
     * 是否国内/国际
     */
    private String domInt;
    /**
     * 是否海关监管
     */
    private String customCtl;
    /**
     * 特殊处理代码
     */
    private String specopeId;
    /**
     * 特殊处理代码扩展
     */
    private String specopeIdExt;
    /**
     * 始发站三字码
     */
    private String sAirportId;
    /**
     * 始发城市代码
     */
    private String sCityId;
    /**
     * 目的站机场代码
     */
    private String eAirportId;
    /**
     * 目的站城市代码
     */
    private String eCityId;
    /**
     * 第一到达站承运人代码
     */
    private String by1;
    /**
     * 第一到达站机场代码
     */
    private String dest1;
    /**
     * 第一到达站城市代码
     */
    private String dest1City;
    /**
     * 第二到达站承运人代码
     */
    private String by2;
    /**
     * 第二到达站机场代码
     */
    private String dest2;
    /**
     * 第二到达站城市代码
     */
    private String dest2City;
    /**
     * 第三到达站承运人代码
     */
    private String by3;
    /**
     * 第三到达站机场代码
     */
    private String dest3;
    /**
     * 第三到达站城市代码
     */
    private String dest3City;
    /**
     * 第四到达站承运人代码
     */
    private String by4;
    /**
     * 第四到达站机场代码
     */
    private String dest4;
    /**
     * 第四到达站城市代码
     */
    private String dest4City;
    /**
     * 品名
     */
    private String cargoNo;
    /**
     * 品名描述
     */
    private String cargoNm;
    /**
     * 中文品名描述
     */
    private String cnCargoNm;
    /**
     * 包装
     */
    private String pack;
    /**
     * 尺寸
     */
    private String meas;
    /**
     * 件数
     */
    private Integer pcs;
    /**
     * 重量（单位公斤）
     */
    private Double weight;
    /**
     * 计费重量
     */
    private Double feeWt;
    /**
     * 体积（单位立方米）
     */
    private Double vol;
    /**
     * 控制营业点
     */
    private String ctrlOpeDepartment;
    /**
     * 发货人名称
     */
    private String shprName;
    /**
     * 发货人电话
     */
    private String shprTel;
    /**
     * 发货人地址
     */
    private String shprAddress;
    /**
     * 发货代理人代码
     */
    private String shpCustomerId;
    /**
     * 发货代理人名称
     */
    private String shpCustomerName;
    /**
     * 收货人名称
     */
    private String cnsnName;
    /**
     * 收货人电话
     */
    private String cnsnTel;
    /**
     * 收货人地址
     */
    private String cnsnAddress;
    /**
     * 收货代理人代码
     */
    private String csgCustomerId;
    /**
     * 收货代理人名称
     */
    private String csgCustomerName;
    /**
     * 预配航班号承运人
     */
    private String preAirline;
    /**
     * 预配航班号
     */
    private String preFlightNo;
    /**
     * 预配航班日期
     */
    private Date preFlightDate;
    /**
     * 需到付
     */
    private String collected;
    /**
     * 汇率
     */
    private Double exchageRate;
    /**
     * COMAT标记
     */
    private String comat;
    /**
     * 需冷藏
     */
    private String refrigerated;
    /**
     * 使用叉车数
     */
    private Double forkNum;
    /**
     * 超限
     */
    private String overlimited;
    /**
     * 压仓标识
     */
    private String whsHold;
    /**
     * 出口转关货标识
     */
    private String expCustTransit;
    /**
     * 进口转关货标识
     */
    private String impCustTransit;
    /**
     * 短途转驳标识
     */
    private String shortTrans;
    /**
     * 短途转驳代理装卸标识
     */
    private String shortTransbup;
    /**
     * 大货主
     */
    private String cargoOwner;
    /**
     * 计费开始时间
     */
    private Date chargeTime;
    /**
     * 是否机场自己销售运单
     */
    private String isInstruction;
    /**
     * 另请通知
     */
    private String notify;
    /**
     * 托运人声明的价值
     */
    private Double shipperValue;
    /**
     * 供运输用
     */
    private Double trafficValue;
    /**
     * 供海关用
     */
    private Double customValue;
    /**
     * 保险金额
     */
    private Double insureValue;
    /**
     * 随附文件名称组合成的字符串，以;分隔
     */
    private String fileAttached;
    /**
     * 运价类别
     */
    private String rateType;
    /**
     * 在货物不能交予收货人时托运人指示的处理办法
     */
    private String processingMethod;
    /**
     * 处理情况
     */
    private String handlingCircs;
    /**
     * 已预留吨位
     */
    private String reservedTonnage;
    /**
     * 运费
     */
    private Double carriage;
    /**
     * 费率
     */
    private Double rate;
    /**
     * 预配航班号第二组
     */
    private String preFlightNo1;
    /**
     * 预配航班日期第二组
     */
    private Date preFlightDate1;
    /**
     * crtoper
     */
    private String crtOper;
    /**
     * 预配航班号承运人第二组
     */
    private String preAirline1;
    /**
     * 重量单位
     */
    private String wtUnit;
    /**
     * 原始重量数值
     */
    private Double originalWt;
    /**
     * 原始计费重量数值
     */
    private Double originalFeeWt;
    /**
     * 体积单位
     */
    private String volUnit;
    /**
     * 货币种类
     */
    private String currencyId;
    /**
     * 原始体积数值
     */
    private Double originalVol;
    /**
     * 创建时间
     */
    private Date crtopeTime;
    /**
     * 提货优先处理标记 Y优先 N不优先
     */
    private String dlvPriority;
    /**
     * 审核完毕
     */
    private String chked;
    /**
     * 合计打印标签数
     */
    private Integer labelNum;
    /**
     * 发货人代码
     */
    private String shpCustomer;
    /**
     * 填开代理人
     */
    private String crtAgent;
    /**
     * 填开日期
     */
    private Date crtDate;
    /**
     * 超限重量
     */
    private Double extraWeight;
    /**
     * 储运注意事项
     */
    private String storeRemark;
    /**
     * 结算注意事项
     */
    private String balanceRemark;
    /**
     * 文件审核完毕
     */
    private String fileChked;
    /**
     * 是否整车复磅.Y=是;N=否
     */
    private String isCarBalance;
    /**
     * 收货人身份证号码
     */
    private String cnsnIdCard;
    /**
     * 是否商检放行
     */
    private String ciqCheck;
    /**
     * 临时单号
     */
    private String tmpBillNo;
    /**
     * 后4位运单号
     */
    private String subBillId;
    /**
     * 进港是否中转
     */
    private String isTrans;
    /**
     * 拆分提货标志位
     */
    private String splitTag;
    /**
     * 转关标记
     */
    private String customsTrans;
    /**
     * endOper
     */
    private String endOper;
    /**
     * endOpeTime
     */
    private Date endOpeTime;
    /**
     * 制单人
     */
    private String confirmOper;
    /**
     * 制单时间
     */
    private Date confirmOpeTime;
    /**
     * 收货人ID
     */
    private String csgCustomer;
    /**
     * 补重单关联的原单
     */
    private String relationBillId;
    /**
     * 板箱类型
     */
    private String uldType;
    /**
     * 板箱号
     */
    private String uldNo;
    /**
     * uldCorp
     */
    private String uldCorp;
    /**
     * 文件到达
     */
    private String docArrival;
    /**
     * 是否有申报单
     */
    private String declarationForm;
    /**
     * 是否有检查单
     */
    private String checkList;
    /**
     * 运单装配优先级
     */
    private Integer loadLevelId;
    /**
     * 运单关联的照片信息
     */
    private String picId;
    /**
     * 是否逾期
     */
    private String isOverdue;
    /**
     * 运单预配目的站
     */
    private String preEAirport;
    /**
     * 当前航站
     */
    private String currAirport;
    /**
     * 发送入库报文时 使用的货物类型 1普通货物 2快件ABC 3快件D类 4跨境货物
     */
    private String cargoType;
    /**
     * 当前操作航站
     */
    private String airportId;
    /**
     * 业务操作人
     */
    private String operator;
    /**
     * 操作营业点
     */
    private String opedepartId;
    /**
     * 设备来源
     */
    private String accessMode;
    /**
     * 营业点类型:I=内部营业点,E=外部营业点
     */
    private String departIdType;
    /**
     * 运单类型
     */
    private String direction;
    /**
     * 库存 stockpre||'-'||stockno
     */
    private String stock;
    /**
     * 货源地
     */
    private String cargoSource;
    /**
     * 是否显示店里人 Y / N或空
     */
    private String IfShowCustomerId;
    /**
     *
     */
    private Double actualFeeWt;
    /**
     * 机舱位
     */
    private String deckCode;
    /**
     * 转关类型
     */
    private String customsTransType;
    /**
     * 落装：Y落装，N非落装
     */
    private String offload;
    /**
     * 是否危险品：Y=是;N=否
     */
    private String isDgr;
    /**
     * 工作量记录人
     */
    private String jobName;
    /**
     * 工作量记录时间
     */
    private Date jobTime;
    /**
     * 是否快提
     */
    private String isFastDlv;
    /**
     * 是否货包机
     */
    private String isCht;
    /**
     * 发送非卡口提离时 使用的货物类型 1进口货物 2进境空转货物 3 跨境货物
     */
    private String cargoTypeNoGate;
    /**
     * 加急标识 N 非加急 L 普通加急 H 特别加急 数据字典URGENTLEVEL
     */
    private String isUrgent;
    /**
     * 交货人
     */
    private String deliveryMan;
    /**
     * 是否锁单
     */
    private String islock;
    /**
     * 是否电子运单
     */
    private String iseawb;
    /**
     * 电子运单接收时间
     */
    private Date eawbrcvtime;
    /**
     * 货站确认尺寸:格式length-width-height/Pcs，多个以英文分号;隔开 单位:CM
     */
    private String confmMeas;
    /**
     * 货站确认计费重量（单位公斤）
     */
    private Double confmFeewt;
    /**
     * 货站确认体积（单位立方米）
     */
    private Double confmVol;
    /**
     * 始发城市名称
     */
    private String sCityName;
    /**
     * 作废标识
     */
    private String delFlag;
    /**
     * 转关号
     */
    private String transitNo;
    /**
     * 运抵报告编号
     */
    private String fohNumber;
    /**
     * 运抵报告编号
     */
    private String transType;
    private String fallStatus;
    private String oldStockpre;
    private String reconfigurationBillid;
    /**
     * 转关地
     */
    private String customsCity;
    /**
     * 海关备注
     */
    private String customsRemark;
    private String singleBillTo;
    /**
     * 运单信息是否通过报文导入生成,默认"N"
     */
    private String fromMsg;
    /**
     * 生成运单信息的报文类型
     */
    private String fromMsgType;
    private String icusexphwbrcv;
}

