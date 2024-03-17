package com.prokhure.erp.infrastructure.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BankSeedDto {
    public BankSeedDto() {}
    public BankSeedDto(String bankName, String bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }
    private String bankName;
    private String bankCode;

    public List<BankSeedDto>  bankSeed() {
        List<BankSeedDto> bankSeedDtos = new ArrayList<>();
        bankSeedDtos.add(new BankSeedDto("STERLING", "000001"));
        bankSeedDtos.add(new BankSeedDto("KEYSTONE", "000002"));
        bankSeedDtos.add(new BankSeedDto("FCMB", "000003"));
        bankSeedDtos.add(new BankSeedDto("UBA", "000004"));
        bankSeedDtos.add(new BankSeedDto("DIAMOND", "000005"));
        bankSeedDtos.add(new BankSeedDto("JAIZ", "000006"));
        bankSeedDtos.add(new BankSeedDto("FIDELITY", "000007"));
        bankSeedDtos.add(new BankSeedDto("POLARI", "000008"));
        bankSeedDtos.add(new BankSeedDto("CITIBANK", "000009"));
        bankSeedDtos.add(new BankSeedDto("ECOBANK", "000010"));
        bankSeedDtos.add(new BankSeedDto("UNITY", "000011"));
        bankSeedDtos.add(new BankSeedDto("STANBICIBT", "000012"));
        bankSeedDtos.add(new BankSeedDto("GTBANK", "000013"));
        bankSeedDtos.add(new BankSeedDto("ACCESS", "000014"));
        bankSeedDtos.add(new BankSeedDto("ZENITH", "000015"));
        bankSeedDtos.add(new BankSeedDto("FIRST BANK", "000016"));
        bankSeedDtos.add(new BankSeedDto("WEMA", "000017"));
        bankSeedDtos.add(new BankSeedDto("UNIOINBANK", "000018"));
        bankSeedDtos.add(new BankSeedDto("HERITAGE", "000018"));
        bankSeedDtos.add(new BankSeedDto("STANDARDCHARTERED", "000021"));
        bankSeedDtos.add(new BankSeedDto("SUNTRUST", "000022"));
        bankSeedDtos.add(new BankSeedDto("PROVIDUS", "000023"));
        bankSeedDtos.add(new BankSeedDto("RAND MERCHANT BANK", "000024"));
        bankSeedDtos.add(new BankSeedDto("CORONATION", "060001"));
        bankSeedDtos.add(new BankSeedDto("FBNQUEST", "060002"));
        bankSeedDtos.add(new BankSeedDto("NOVAMB", "060003"));
        bankSeedDtos.add(new BankSeedDto("NPF MICROFINANCE BANK", "070001"));
        bankSeedDtos.add(new BankSeedDto("FORTIS MICROFINANCE BANK", "070002"));
        bankSeedDtos.add(new BankSeedDto("CONVENANT MFB", "070006"));
        bankSeedDtos.add(new BankSeedDto("OMOLUABI MORTGAGE BANK PLC", "070007"));
        bankSeedDtos.add(new BankSeedDto("PAGE MFBANK", "070008"));
        bankSeedDtos.add(new BankSeedDto("GATEWAY MORTGAGE BANK", "070009"));
        bankSeedDtos.add(new BankSeedDto("ABBEY MORTGAGE BANK", "070010"));
        bankSeedDtos.add(new BankSeedDto("REFUGE MORTGAGE BANK", "070011"));
        bankSeedDtos.add(new BankSeedDto("LBIC MORTGAGE BANK", "070012"));
        bankSeedDtos.add(new BankSeedDto("PLATINUM MORTGAGE BANK", "070013"));
        bankSeedDtos.add(new BankSeedDto("FIRST GENERATION MORTGAGE BANK", "070014"));
        bankSeedDtos.add(new BankSeedDto("BRENT MORTGAGE BANK", "070015"));
        bankSeedDtos.add(new BankSeedDto("INFINITY TRUST MORTGAGE BANK", "070016"));
        bankSeedDtos.add(new BankSeedDto("HAGGAI MORTGAGE BANK", "070017"));
        bankSeedDtos.add(new BankSeedDto("ASOSAVINGS", "090001"));
        bankSeedDtos.add(new BankSeedDto("JUBILEELIFE", "090003"));
        bankSeedDtos.add(new BankSeedDto("PARRALEX", "090004"));
        bankSeedDtos.add(new BankSeedDto("TRUSTBOND", "090005"));
        bankSeedDtos.add(new BankSeedDto("SAFETRUST", "090006"));
        bankSeedDtos.add(new BankSeedDto("EKONDO MFB", "090097"));
        bankSeedDtos.add(new BankSeedDto("FBN MORGAGES LIMITED", "090107"));
        bankSeedDtos.add(new BankSeedDto("NEW PRUDENTIAL BANK", "090108"));
        bankSeedDtos.add(new BankSeedDto("VFO MFB", "090110"));
        bankSeedDtos.add(new BankSeedDto("FINATRUST MICROFINANCE BANK", "090111"));
        bankSeedDtos.add(new BankSeedDto("SEED CAPITAL MICROFINANVE BANK", "090112"));
        bankSeedDtos.add(new BankSeedDto("EMPIRE MFB", "090114"));
        bankSeedDtos.add(new BankSeedDto("TCF", "090115"));
        bankSeedDtos.add(new BankSeedDto("AMML MFB", "090116"));
        bankSeedDtos.add(new BankSeedDto("BOCTRUST MICROFINANCE BANK", "090117"));
        bankSeedDtos.add(new BankSeedDto("IBILE MICROFINANCE BANK", "090118"));
        bankSeedDtos.add(new BankSeedDto("OHAFIA MFB", "090119"));
        bankSeedDtos.add(new BankSeedDto("WETLAND MFB", "090120"));
        bankSeedDtos.add(new BankSeedDto("HASAL MFB", "090121"));
        bankSeedDtos.add(new BankSeedDto("GOWANS MFB", "090122"));
        bankSeedDtos.add(new BankSeedDto("VERITE MICROFINAMCE BANK", "090123"));
        bankSeedDtos.add(new BankSeedDto("XSLNCE", "090124"));
        bankSeedDtos.add(new BankSeedDto("REGENT", "090125"));
        bankSeedDtos.add(new BankSeedDto("FIDFUND MFB", "090126"));
        bankSeedDtos.add(new BankSeedDto("BC KASH MFB", "090127"));
        bankSeedDtos.add(new BankSeedDto("NDIORAH MFB", "090128"));
        bankSeedDtos.add(new BankSeedDto("MONEYTRUST MFB", "090129"));
        bankSeedDtos.add(new BankSeedDto("CONSUMER MFB", "090130"));
        bankSeedDtos.add(new BankSeedDto("ALLWORKERRS MFB", "090131"));
        bankSeedDtos.add(new BankSeedDto("RICHWAY MFB", "090132"));
        bankSeedDtos.add(new BankSeedDto("AL-BARKAH MFB", "090133"));
        bankSeedDtos.add(new BankSeedDto("ACCION MFB", "090134"));
        bankSeedDtos.add(new BankSeedDto("PERSONAL TRUST MICROFINANCE BANK", "090135"));
        bankSeedDtos.add(new BankSeedDto("MICROCRED MICROFINANCE BANK", "090136"));
        bankSeedDtos.add(new BankSeedDto("PECAN TRUST MICROFINANCE BANK", "090137"));
        bankSeedDtos.add(new BankSeedDto("ROYAL EXCHANGE MICROFINANCE BANK", "090138"));
        bankSeedDtos.add(new BankSeedDto("VISA MICROFINANCE BANK", "090139"));
        bankSeedDtos.add(new BankSeedDto("SAGAMU MICROFINANCE BANK", "090140"));
        bankSeedDtos.add(new BankSeedDto("CHIKUM MICROFINANCE BANK", "090141"));
        bankSeedDtos.add(new BankSeedDto("YES MFB", "090142"));
        bankSeedDtos.add(new BankSeedDto("APEKS MICROFINANCE BANK", "090143"));
        bankSeedDtos.add(new BankSeedDto("CIT MICROFINANCE BANK", "090144"));
        bankSeedDtos.add(new BankSeedDto("FULL RANGE MFB", "090145"));
        bankSeedDtos.add(new BankSeedDto("TRIDENT MICROFINANCE BANK", "090146"));
        bankSeedDtos.add(new BankSeedDto("HACKMAN MICROFINANCE BANK", "090147"));
        bankSeedDtos.add(new BankSeedDto("BOWEN MFB", "090148"));
        bankSeedDtos.add(new BankSeedDto("IRL MICROFINANCE BANK", "090149"));
        bankSeedDtos.add(new BankSeedDto("VIRTUE MFB", "090150"));
        bankSeedDtos.add(new BankSeedDto("MUTUAL TRUST MICROFINANCE BANK", "090151"));
        bankSeedDtos.add(new BankSeedDto("NARGATA MFB", "090152"));
        bankSeedDtos.add(new BankSeedDto("FFS MICROFINANCE BANK", "090153"));
        bankSeedDtos.add(new BankSeedDto("CEMCS MFB", "090154"));
        bankSeedDtos.add(new BankSeedDto("LAFAYETTE MICROFINANCE BANK", "090155"));
        bankSeedDtos.add(new BankSeedDto("E-BARCS MFB", "090156"));
        bankSeedDtos.add(new BankSeedDto("INFINITY MFB", "090157"));
        bankSeedDtos.add(new BankSeedDto("FUTO MFB", "090158"));
        bankSeedDtos.add(new BankSeedDto("HIGH STREET MFB", "090175"));
        bankSeedDtos.add(new BankSeedDto("PAYCOM", "100004"));
        bankSeedDtos.add(new BankSeedDto("KUDA MICROFINANCE BANK", "090267"));
        bankSeedDtos.add(new BankSeedDto("GLOBUS BANK", "000027"));
        bankSeedDtos.add(new BankSeedDto("PAGA", "100002"));
        bankSeedDtos.add(new BankSeedDto("PAYATTITUDE ONLINE", "110001"));
        bankSeedDtos.add(new BankSeedDto("Titan Trust Bank Ltd", "110001"));
        bankSeedDtos.add(new BankSeedDto("FET", "100001"));
        bankSeedDtos.add(new BankSeedDto("CREDIT AFRIQUE MFB", "090159"));
        return bankSeedDtos;
    }
}
