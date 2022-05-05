import javax.security.cert.*;
/**
     * Data class to hold Signature, Certificate (and its chain(s)) and revocation Information
     */
    public class CertSignatureInformation
    {
        private X509Certificate certificate;
        private String signatureHash;
        private boolean isSelfSigned = false;
        private String ocspUrl;
        private String crlUrl;
        private String issuerUrl;
        private X509Certificate issuerCertificate;
        private CertSignatureInformation certChain;
        private CertSignatureInformation tsaCerts;
        private CertSignatureInformation alternativeCertChain;

        public String getOcspUrl()
        {
            return ocspUrl;
        }

        public void setOcspUrl(String ocspUrl)
        {
            this.ocspUrl = ocspUrl;
        }

        public void setIssuerUrl(String issuerUrl)
        {
            this.issuerUrl = issuerUrl;
        }

        public String getCrlUrl()
        {
            return crlUrl;
        }

        public X509Certificate getCertificate()
        {
            return certificate;
        }

        public boolean isSelfSigned()
        {
            return isSelfSigned;
        }

        public X509Certificate getIssuerCertificate()
        {
            return issuerCertificate;
        }

        public String getSignatureHash()
        {
            return signatureHash;
        }

        public CertSignatureInformation getCertChain()
        {
            return certChain;
        }

        public CertSignatureInformation getTsaCerts()
        {
            return tsaCerts;
        }

        public CertSignatureInformation getAlternativeCertChain()
        {
            return alternativeCertChain;
        }
    }
